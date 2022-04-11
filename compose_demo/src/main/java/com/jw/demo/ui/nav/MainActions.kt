package com.jw.demo.ui.nav

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.demo.ui.nav
 * @Author jianwen.zhou
 * @Date 2022/4/10 21:59
 * @Des APP的跳转管理
 */
object MainDestinations {
    const val SPLASH_ROUTER = "jw/splash"
    const val MAIN_ROUTE = "jw/main"
}

class MainActions(navController: NavHostController) {

    //打开首页
    val openMain = { from: NavBackStackEntry ->
        if (from.lifecycleIsResumed()) {
            navController.navigate(MainDestinations.MAIN_ROUTE)
        }
    }

    val onboardingComplete: () -> Unit = {
        navController.popBackStack()
    }

    val upPress: (from: NavBackStackEntry) -> Unit = { from ->
        if (from.lifecycleIsResumed()) {
            navController.navigateUp()
        }
    }
}

/**
 * 如果生命周期没有恢复，则意味着此 NavBackStackEntry 已经处理了一个导航事件。
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED
