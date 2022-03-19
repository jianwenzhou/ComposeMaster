package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/19 16:43
 * @Des  compose中滚动事件,实现类似原生ScrollView的效果。同理Row也可以通过该修饰符实现横向滚动。
 * 要点1:通过verticalScroll修饰符,借助rememberScrollState可以实现垂直滚动.
 * 要点2:可以借助rememberScrollState,将Column滚动到指定位置.
 * 要点3:通过Scrollable修饰符,可以监听滑动的距离
 */
@Composable
fun MyScrollGesture() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        VerticalScroll()
        Spacer(modifier = Modifier.size(50.dp))
        ScrollableSample()
        Spacer(modifier = Modifier.size(50.dp))
        NestedScroll()
    }
}

/**
 * 通过verticalScroll修饰符,借助rememberScrollState可以实现垂直滚动.
 */
@Composable
fun VerticalScroll() {

    val scrollState = rememberScrollState()

    //启动协程,动画形式滚动到1000px的位置.
    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(1000)
    }

    Text(text = "通过verticalScroll修饰符,借助rememberScrollState可以实现垂直滚动.")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colors.primary.copy(0.2f))
            .verticalScroll(scrollState)
    ) {
        repeat(100) {
            Text(text = "测试条目:$it")
        }
    }

}

/**
 *通过Scrollable修饰符,可以监听滑动的距离
 */
@Composable
fun ScrollableSample() {

    var offset by remember {
        mutableStateOf(0f)
    }
    Text(text = "通过Scrollable修饰符,可以监听滑动的距离.")
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colors.primary.copy(0.2f))
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollableState { delta ->
                    offset += delta
                    delta
                }
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = offset.toString())
    }

}

/**
 * 嵌套滚动,Compose已经做了优化,一般子控件无法滚动时候,才会滚动父组件.
 */
@Composable
fun NestedScroll() {

    //渐变色
    val verticalGradient = Brush.verticalGradient(
        0f to Color.Gray, 1000f to Color.White
    )

    Text(text = "嵌套滚动,Compose已经做了优化,一般子控件无法滚动时候,才会滚动父组件.")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(MaterialTheme.colors.primary.copy(0.2f))
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            repeat(10) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Green)
                        .padding(10.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "测试文本", modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .background(verticalGradient)
                    )

                }

            }
        }
    }

}