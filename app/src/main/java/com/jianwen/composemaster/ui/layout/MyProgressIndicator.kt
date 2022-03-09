package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 23:42
 * @Des ProgressIndicator，进度条。
 */
@Composable
fun MyProgressIndicator() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(20.dp), color = Color.Yellow,
            strokeWidth = 1.dp
        )

        Spacer(modifier = Modifier.size(20.dp))

        LinearProgressIndicator(
            modifier = Modifier.size(width = 80.dp, height = 10.dp), color = Color.Yellow,
            backgroundColor = Color.Yellow.copy(0.5f)
        )
    }
}
