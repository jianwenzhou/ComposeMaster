package com.jw.basics.ui.layout

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jw.basics.R

@Composable
fun MyAnimate() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
            .verticalScroll(rememberScrollState()) //垂直滚动
    ) {
        //展示隐藏动画1
        VisibleAnim1()
        //展示隐藏动画2
        VisibleAnim2()
        //颜色色值变化动画
        VisibleAnim3()
        //为内容大小变化添加动画效果
        VisibleAnim4()
        //重复动画
        VisibleAnim5()

    }
}

@Composable
fun VisibleAnim1() {
    var isVis by remember { mutableStateOf(true) }
    Text(text = "默认AnimatedVisibility")
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = isVis) {
            Image(
                painter = painterResource(id = R.mipmap.main),
                contentDescription = "",
                Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
        }
        Button(onClick = { isVis = !isVis }) {
            Text(text = "Start", color = MaterialTheme.colors.onSecondary)
        }
    }

}

@Composable
fun VisibleAnim2() {
    var isVis by remember { mutableStateOf(true) }
    Text(text = "定制AnimatedVisibility")
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = isVis,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.mipmap.main),
                contentDescription = "",
                Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
        }

        Button(onClick = { isVis = !isVis }) {
            Text(text = "Start", color = MaterialTheme.colors.onSecondary)
        }
    }
}

@Composable
fun VisibleAnim3() {
    var isChange by remember { mutableStateOf(true) }
    Text(text = "animateColorAsState 颜色变化")
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val backgroundColor by animateColorAsState(if (isChange) Color.Red else Color.Yellow)

        Box(
            Modifier
                .size(200.dp)
                .background(backgroundColor)
        )

        Button(onClick = { isChange = !isChange }) {
            Text(text = "Start", color = MaterialTheme.colors.onSecondary)
        }
    }
}

@Composable
fun VisibleAnim4() {
    var isOpen by remember { mutableStateOf(false) }
    Text(text = "animateContentSize 动画切换大小")
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n" +
                    "In this tutorial, you'll build a simple UI component with declarative functions. You won't be editing any XML layouts or using the Layout Editor. Instead, you will call Jetpack Compose functions to say what elements you want, and the Compose compiler will do the rest.",
            maxLines = if (isOpen) Int.MAX_VALUE else 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
                .animateContentSize()
        )

        Button(onClick = { isOpen = !isOpen }) {
            Text(text = "Start", color = MaterialTheme.colors.onSecondary)
        }
    }
}

@Composable
fun VisibleAnim5() {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    )

    Text(text = "rememberInfiniteTransition 循环动画")
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            Modifier
                .size(200.dp)
                .background(MaterialTheme.colors.primary.copy(alpha))
        )


    }
}