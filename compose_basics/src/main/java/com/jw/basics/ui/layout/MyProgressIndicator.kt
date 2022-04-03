package com.jw.basics.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
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

        MyLinearProgressIndicator()
    }
}

@Composable
fun MyLinearProgressIndicator() {
    LinearProgressIndicator(
        modifier = Modifier.size(width = 80.dp, height = 5.dp),
        color = MaterialTheme.colors.primary,
        backgroundColor = MaterialTheme.colors.primary.copy(0.4f)
    )
}