package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/22 20:42
 * @Des LaunchedEffect:第一次调用Compose函数的时候调用,
 * 当key发生变化的时候，会重新启动一个携程执行block。
 */
@Composable
fun MyLaunchedEffect() {

    LaunchedEffect1()

}

@Composable
private fun LaunchedEffect1() {
    var key1 by remember { mutableStateOf(false) }

    val rememberScaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = key1) {
        rememberScaffoldState.snackbarHostState.showSnackbar(
            message = "Message",
            actionLabel = "actionLabel"
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = rememberScaffoldState,
        topBar = { Text(text = "LaunchedEffect示例", style = MaterialTheme.typography.h4) },) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "LaunchedEffect:第一次调用Compose函数的时候调用,当key发生变化的时候，会重新启动一个携程执行block。")

            Spacer(modifier = Modifier.size(20.dp))

            Button(
                onClick = { key1 = !key1 }//每次点击按钮，key1都会发生变化，LaunchedEffect的block都会执行。
            ) {
                Text(text = "Show Snack Bar", textAlign = TextAlign.Center)
            }
        }

    }
}
