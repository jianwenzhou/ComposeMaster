package com.jianwen.composemaster.simple

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jianwen.composemaster.net.api.const.NetConst
import com.jianwen.composemaster.net.api.entity.Hit
import com.jianwen.composemaster.net.api.entity.ImageEntity
import com.jianwen.composemaster.net.api.manager.ApiFactory
import com.jianwen.composemaster.net.api.manager.CallBackWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.simple
 * @Author jianwen.zhou
 * @Date 2022/3/10 23:25
 * @Des
 */
class SimpleViewModel : ViewModel() {

    //************图片资源获取*************/
    val imageLiveData = MutableLiveData<MutableList<Hit>>()

    //搜索图片相关的常量
    val orientation = "vertical"
    val lang = "zh"
    val q = "风景"

    /**
     * 下拉刷新或者首次刷新 为true
     */
    fun getImageList(
        page: Int = 1,
        per_page: Int = 20,
        key: String = q,
        onDataSuccess: () -> Unit = {}
    ) {
        return ApiFactory.getImageData()
            .getImageList(NetConst.PixabayImageKey, page, per_page, orientation, lang, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CallBackWrapper<ImageEntity>() {
                override fun onSuccess(t: ImageEntity) {
                    imageLiveData.value = t.hits
                    onDataSuccess()
                }
            })
    }
    //*************end*************/


    //************下拉刷新测试*************/
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    fun refresh() {
        _isRefreshing.value = true
        getImageList {
            _isRefreshing.value = false
        }
    }
    //*************end*************/

}