package com.hstong.demo.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hstong.demo.model.MainViewModel

/**
 * @ProjectName ComposeMaster
 * @PackageName com.hstong.demo
 * @Author jianwen.zhou
 * @Date 2022/4/1 23:03
 * @Des
 */

@Composable
fun MainCompose() {
    val navControllers = rememberNavController()

    Scaffold(
        bottomBar = { MainBottomBar(navControllers = navControllers) },
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(navControllers, startDestination = MainViewModel.Screen.Hot.route) {
            // 火热
            composable(MainViewModel.Screen.Hot.route) { HomePage(navControllers) }
            // 发现
            composable(MainViewModel.Screen.Find.route) { FindPage(navControllers) }
            // 我的
            composable(MainViewModel.Screen.Me.route) { MePage(navControllers) }
        }
    }
}


@Composable
fun MainBottomBar(
    model: MainViewModel = viewModel(),
    navControllers: NavHostController = rememberNavController()
) {

    // 记住选中tab位置
    val selectIndex = remember {
        mutableStateOf(0)
    }

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 3.dp
    ) {

        val navBackStackEntry by navControllers.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString("")

        model.items.forEachIndexed { index, s ->

            BottomNavigationItem(
                selected = currentRoute == s.route,
                onClick = {
                    selectIndex.value = index
                    navControllers.navigate(s.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo = navControllers.graph.startDestinationId
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                    }
                },
                icon = {
                    when (index) {
                        selectIndex.value -> {
                            Image(
                                painter = painterResource(id = model.tabData[index].iconSelected),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        else -> {
                            Image(
                                painter = painterResource(id = model.tabData[index].iconUnselected),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                },
                label = {
                    Text(
                        text = model.tabData[index].name,
                        textAlign = TextAlign.Center,
                        color = if (index == selectIndex.value) Color(0xFFd4237a) else MaterialTheme.colors.onBackground
                    )
                })

        }
    }
}
