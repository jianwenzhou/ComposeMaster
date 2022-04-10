package com.jw.demo.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.jw.demo.ui.nav.MainActions
import com.jw.demo.ui.nav.MainDestinations
import com.jw.demo.ui.nav.TabData
import com.jw.demo.ui.nav.courses

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.demo
 * @Author jianwen.zhou
 * @Date 2022/4/1 23:03
 * @Des 主界面导航
 */
@Composable
fun JwNavGraph(
    modifier: Modifier = Modifier,
    finishActivity: () -> Unit = {},
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.MAIN_ROUTE,
) {

    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        navigation(
            route = MainDestinations.MAIN_ROUTE,
            startDestination = TabData.Hot.route
        ) {
            courses(
                navController = navController,
                modifier = modifier
            )
        }

    }
}

