package com.jw.demo.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SplashPage(
    actions: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Text(text = "明天更美好", modifier = Modifier.align(Alignment.Center))

        Button(
            onClick = {
                //关闭闪屏页，展示主页
                actions()
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.dp)
        ) {
            Text(text = "跳过")
        }


    }
}