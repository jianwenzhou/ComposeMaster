package com.jw.demo.model

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jw.http.const.NetConst
import com.jw.http.entity.Hit
import com.jw.http.entity.ImageEntity
import com.jw.http.manager.ApiFactory
import com.jw.http.manager.CallBackWrapper
import com.jw.demo.R
import com.jw.demo.data.TabData
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

    /************底部tab数据*************/

    val tabData = listOf(
        TabData("火热", R.mipmap.ic_hot_selected,R.mipmap.ic_hot_unselected),
        TabData("发现", R.mipmap.ic_find_selected,R.mipmap.ic_find_unselected),
        TabData("我的", R.mipmap.ic_me_selected,R.mipmap.ic_me_unselected),
    )


    sealed class Screen(val route: String, @StringRes val resourceId: Int) {
        object Hot : Screen("Hot", R.string.hot)
        object Find : Screen("Find", R.string.find)
        object Me : Screen("Me", R.string.me)

    }

    val items = listOf(
        Screen.Hot,
        Screen.Find,
        Screen.Me
    )

    /*************end*************/

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