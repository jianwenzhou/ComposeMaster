package com.jw.demo.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jw.demo.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.demo.data
 * @Author jianwen.zhou
 * @Date 2022/4/1 23:13
 * @Des
 */
enum class TabData(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    Hot(R.string.hot, R.mipmap.ic_hot_selected, TabDestinations.HOT_ROUTE),
    Find(R.string.find, R.mipmap.ic_find_selected, TabDestinations.FIND_ROUTE),
    Me(R.string.me, R.mipmap.ic_me_selected, TabDestinations.ME_ROUTE)
}


private object TabDestinations {
    const val HOT_ROUTE = "jw/hot"
    const val FIND_ROUTE = "jw/find"
    const val ME_ROUTE = "jw/me"
}
