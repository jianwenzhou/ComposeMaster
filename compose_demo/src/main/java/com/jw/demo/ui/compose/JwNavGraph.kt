package com.jw.demo.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jw.demo.data.TabData

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.demo
 * @Author jianwen.zhou
 * @Date 2022/4/1 23:03
 * @Des 主界面导航
 */
@Composable
fun JwNavGraph(
    navController: NavHostController,
    modifier: Modifier,
    startDestination: String = TabData.Hot.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(TabData.Hot.route) {
            HotPage(navController)
        }
        composable(TabData.Find.route) {
            FindPage(navController)
        }
        composable(TabData.Me.route) {
            MePage(navController)
        }

    }
}
