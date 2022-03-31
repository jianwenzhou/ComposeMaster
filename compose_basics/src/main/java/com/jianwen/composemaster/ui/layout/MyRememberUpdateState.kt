package com.jianwen.composemaster.ui.layout

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/22 20:42
 * @Des rememberUpdatedState:可以使LaunchedEffect的协程中，总是使用到最新的值，而不用重启协程。
 */
@Composable
fun MyRememberUpdateState() {

    val onTimeOut1: () -> Unit = { Log.d("zjw", "我是TimeOut1") }
    val onTimeOut2: () -> Unit = { Log.d("zjw", "我是TimeOut2") }

    val onTimeOutState = remember {
        mutableStateOf(onTimeOut1)
    }

    RememberUpdatedState(onTimeOutState.value)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "rememberUpdatedState:可以使LaunchedEffect的协程中，总是使用到最新的值，而不用重启协程。")

        Spacer(modifier = Modifier.size(20.dp))

        Button(onClick = {
            onTimeOutState.value = onTimeOut2
        }) {
            Text(text = "Choose onTimeOut")
        }
    }

}


@Composable
fun RememberUpdatedState(onTimeOut: () -> Unit) {
    val current by rememberUpdatedState(newValue = onTimeOut)

    LaunchedEffect(key1 = Unit, block = {
        Log.d("zjw", "onTimeStart")
        repeat(10) {
            delay(1000)
            Log.d("zjw", "time: ${it + 1} S")
        }
        current()
    })
}
