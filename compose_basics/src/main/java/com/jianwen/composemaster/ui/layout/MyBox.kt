package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/8 21:42
 * @Des Box，嵌套布局，类似原生View的帧布局。
 */
@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .width(360.dp)
            .height(200.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        //子Box1
        Box(
            modifier = Modifier
                .fillMaxSize(0.5f)
                .background(color = Color.Black)
        )

        //子Box2
        Box(
            modifier = Modifier
                .fillMaxSize(0.2f)
                .background(color = Color.White)
        )
    }
}

@Preview
@Composable
fun MyBoxPreview() {
    MyBox()
}