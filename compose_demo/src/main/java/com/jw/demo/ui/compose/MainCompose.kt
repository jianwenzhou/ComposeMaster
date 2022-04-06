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
import com.jw.demo.data.TabData
import java.util.*

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.demo
 * @Author jianwen.zhou
 * @Date 2022/4/1 23:03
 * @Des 主界面，包含底部tab
 */

@Composable
fun MainCompose() {

    val tabs = remember { TabData.values() }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { MainBottomBar(navController = navController, tabs = tabs) },
        backgroundColor = MaterialTheme.colors.primarySurface,
    ) { innerPaddingModifier ->
        JwNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPaddingModifier)
        )
    }
}


@Composable
fun MainBottomBar(
    navController: NavHostController = rememberNavController(), tabs: Array<TabData>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: TabData.Hot.route

    val routes = remember { TabData.values().map { it.route } }

    if (currentRoute in routes) {

        BottomNavigation(
            Modifier.windowInsetsBottomHeight(
                WindowInsets.navigationBars.add(
                    WindowInsets(
                        bottom = 56.dp
                    )
                )
            )
        ) {
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
