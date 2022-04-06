package com.jw.demo.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jw.demo.R
import com.jw.http.const.NetConst
import com.jw.http.entity.Hit
import com.jw.http.entity.ImageEntity
import com.jw.http.manager.ApiFactory
import com.jw.http.manager.CallBackWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.demo.simple
 * @Author jianwen.zhou
 * @Date 2022/3/10 23:25
 * @Des
 */
class MainViewModel : ViewModel() {

    /************图片资源获取*************/
    val imageLiveData = MutableLiveData<MutableList<Hit>>()

    //搜索图片相关的常量
    val orientation = "vertical"
    val lang = "zh"
    val q = "风景"

    /**
     * 获取图片集合
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
    /*************end*************/

}