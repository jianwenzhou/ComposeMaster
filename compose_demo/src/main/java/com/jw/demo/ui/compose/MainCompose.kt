package com.jw.demo.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jw.demo.ui.nav.TabData
import java.util.*

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.demo
 * @Author jianwen.zhou
 * @Date 2022/4/1 23:03
 * @Des 主界面，包含底部tab
 */

@Composable
fun MainCompose(finishActivity: () -> Unit) {

    val tabs = remember { TabData.values() }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { MainBottomBar(navController = navController, tabs = tabs) },
        backgroundColor = MaterialTheme.colors.primarySurface,
    ) { innerPaddingModifier ->
        JwNavGraph(
            modifier = Modifier.padding(innerPaddingModifier),
            finishActivity = finishActivity,
            navController = navController
        )
    }
}


@Composable
fun MainBottomBar(
    navController: NavHostController = rememberNavController(),
    tabs: Array<TabData>
) {
    //当前返回栈
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    //当前路由名称
    val currentRoute = navBackStackEntry?.destination?.route ?: TabData.Hot.route
    //路由集合
    val routes = remember { tabs.map { it.route } }
    //判断当前路由是否属于路由集合
    if (currentRoute in routes) {
        //底部导航组件
        BottomNavigation(
            modifier = Modifier.windowInsetsBottomHeight(
                WindowInsets.navigationBars.add(
                    WindowInsets(
                        bottom = 56.dp
                    )
                )
            )
        ) {
            //遍历tabs创建导航item
            tabs.forEach { tab ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(tab.icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(stringResource(tab.title).uppercase(Locale.getDefault())) },
                    selected = currentRoute == tab.route,
                    onClick = {
                        //当点击的tab非选中状态，就通过navController打开界面。
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    alwaysShowLabel = false,
                    selectedContentColor = MaterialTheme.colors.secondary,
                    unselectedContentColor = LocalContentColor.current,
                    modifier = Modifier.navigationBarsPadding()
                )
            }
        }
    }
}
