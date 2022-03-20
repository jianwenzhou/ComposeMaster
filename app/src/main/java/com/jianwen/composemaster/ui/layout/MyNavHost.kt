package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/20 16:43
 * @Des
 */
@Composable
fun MyNavHost() {

    val list = listOf("中国", "美国", "日本")

    val navController = rememberNavController()

    Scaffold(topBar = {

        RallyTabRow(list) { navController.navigate(it) }

    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RallyNavHost(navController = navController, modifier = Modifier.padding(it))
        }
    }

}

@Composable
private fun RallyTabRow(list: List<String>, onTabSelected: (String) -> Unit) {
    var selected by remember {
        mutableStateOf(0)
    }
    TabRow(selectedTabIndex = selected) {
        list.forEachIndexed { index, name ->
            Tab(selected = selected == index,
                onClick = {
                    selected = index
                    onTabSelected(name)
                }) {
                Text(text = name, style = MaterialTheme.typography.subtitle1)
            }
        }
    }
}

@Composable
fun RallyNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = "中国",
        modifier = modifier,
    ) {

        composable(
            route = "中国"
        ) {
            Text(text = "中国", style = MaterialTheme.typography.h2)
        }

        composable(
            route = "美国"
        ) {
            Text(text = "美国", style = MaterialTheme.typography.h2)
        }

        composable(
            route = "日本"
        ) {
            Text(text = "日本", style = MaterialTheme.typography.h2)
        }

    }
}
