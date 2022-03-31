package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/22 20:42
 * @Des rememberCoroutineScope:可组合函数外启动协程，在可组合函数声明周期结束时候取消.
 */
@Composable
fun MyRememberCoroutineScope() {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "我是drawerContent")
            }
        },
        topBar = {
            TopAppBar(title = { Text(text = "rememberCoroutineScope示例") }, navigationIcon = {
                IconButton(onClick = {
                    scope.launch { scaffoldState.drawerState.open() }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                }
            })
        },
        floatingActionButton = {
            Button(onClick = {
                scope.launch { scaffoldState.snackbarHostState.showSnackbar("点击了floatingActionButton") }
            }) {
                Text(text = "floating")
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "rememberCoroutineScope:可组合函数外启动协程，在可组合函数声明周期结束时候取消.")
        }
    }

}
