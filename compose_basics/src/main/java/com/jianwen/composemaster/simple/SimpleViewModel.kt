package com.jianwen.composemaster.simple

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hstong.api.http.const.NetConst
import com.hstong.api.http.entity.Hit
import com.hstong.api.http.entity.ImageEntity
import com.hstong.api.http.manager.ApiFactory
import com.hstong.api.http.manager.CallBackWrapper
import com.jianwen.composemaster.ui.theme.jThemeDark
import com.jianwen.composemaster.ui.theme.jThemeLight
import com.jianwen.composemaster.ui.theme.zThemeDark
import com.jianwen.composemaster.ui.theme.zThemeLight
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


    //************theme*************/
    var theme by mutableStateOf(zThemeLight)
    fun changeTheme() {
        when (theme) {
            zThemeLight -> {
                theme = zThemeDark
            }
            zThemeDark -> {
                theme = jThemeLight
            }
            jThemeLight -> {
                theme = jThemeDark
            }
            jThemeDark -> {
                theme = zThemeLight
            }
        }
    }


    //*************end*************/
}