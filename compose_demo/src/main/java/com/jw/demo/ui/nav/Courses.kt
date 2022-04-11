package com.jw.demo.ui.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.jw.demo.R
import com.jw.demo.ui.compose.FindPage
import com.jw.demo.ui.compose.HotPage
import com.jw.demo.ui.compose.MePage

/**
 * 首页的nav跳转管理
 */
fun NavGraphBuilder.courses(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onboardingComplete: MutableState<Boolean>
) {
    composable(TabData.Hot.route) {
        //LaunchedEffect，只在可组合函数首次执行，或者key发生变化时候。
        LaunchedEffect(key1 = onboardingComplete, block = {
            if (!onboardingComplete.value) {
                navController.navigate(MainDestinations.SPLASH_ROUTER)
            }
        })
        if (onboardingComplete.value) {
            HotPage(navController, modifier)
        }
    }
    composable(TabData.Find.route) {
        FindPage(navController, modifier)
    }
    composable(TabData.Me.route) {
        MePage(navController, modifier)
    }
}

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
