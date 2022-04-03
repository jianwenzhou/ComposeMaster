package com.jw.basics.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/19 15:34
 * @Des  compose中点击事件设置
 * 点击事件，通过Modifier.clickable添加。
 */
@Composable
fun MyClickableGesture() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableSample()
    }

}


@Composable
fun ClickableSample() {
    var count by remember {
        mutableStateOf(0)
    }
    Text(
        text = "点击:$count",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .size(100.dp)
            .background(MaterialTheme.colors.primary.copy(0.5f))
            .clickable { count++ })
}
