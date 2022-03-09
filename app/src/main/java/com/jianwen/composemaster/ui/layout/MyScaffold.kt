package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * @ProjectName ComposeDemo
 * @PackageName com.jianwen.composedemo.ui
 * @Author jianwen.zhou
 * @Date 2022/3/6 0:16
 * @Des 脚手架,包括顶部应用程序栏和底部栏、抽屉和浮动操作按钮等
 *  modifier = modifier, // 可选修饰符
 *  scaffoldState = scaffoldState,  // 状态
 *  topBar = topBar,  // 顶部程序栏
 *  bottomBar = bottomBar,  // 底部栏
 *  snackbarHost = snackbarHost,// 通过SnackbarHostState.showSnackbar推送显示，可以做类似吐司提示
 *  floatingActionButton = floatingActionButton,  // 浮动操作按钮
 *  floatingActionButtonPosition = floatingActionButtonPosition, // 浮动操作按钮位置
 *  isFloatingActionButtonDocked = isFloatingActionButtonDocked, // 如果存在底部栏，则floatingActionButton是否应与底部栏重叠半个高度。如果没有底部栏或浮动操作按钮，则忽略。
 *  drawerContent = drawerContent,  // 抽屉内容
 *  drawerShape = drawerShape,  // 抽屉形状
 *  drawerElevation = drawerElevation, // 抽屉阴影大小
 *  drawerBackgroundColor = drawerBackgroundColor, // 抽屉背景颜色
 *  drawerContentColor = drawerContentColor,  // 抽屉内容的颜色
 *  drawerScrimColor = drawerScrimColor,// 抽屉打开时遮盖内容的颜色（抽屉打开时与屏幕右边那段距离的颜色）
 *  backgroundColor = backgroundColor,  // 脚手架背景颜色
 *  contentColor = contentColor, // 脚手架内容颜色
 *  content = content  // 脚手架内容
 */

@Composable
fun MyScaffold() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { Text("Drawer content") },
        topBar = {
            TopAppBar(
                title = { Text("Simple Scaffold Screen") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Inc") },
                onClick = { /* fab click handler */ }
            )
        },
        content = { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(count = 100) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(colors.background)
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun MyScaffoldPreview(){
    MyScaffold()
}