package com.jw.basics.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 23:42
 * @Des Divider，主要用于分割线。
 */
@Composable
fun MyDivider() {

    Column(modifier = Modifier.fillMaxSize()) {
        Divider(thickness = 1.dp, color = Color.Red)
        Spacer(modifier = Modifier.size(20.dp))     //类似margin效果
        Divider(thickness = 2.dp, color = Color.Black)
        Spacer(modifier = Modifier.size(20.dp))
        Divider(thickness = 3.dp, color = Color.Blue)
        Spacer(modifier = Modifier.size(20.dp))
        Divider(thickness = 4.dp, color = Color.Green)
        Spacer(modifier = Modifier.size(20.dp))
        Divider(thickness = 5.dp, color = Color.Gray)
        Spacer(modifier = Modifier.size(20.dp))
        Divider(thickness = 6.dp, color = Color.Yellow)
    }

}