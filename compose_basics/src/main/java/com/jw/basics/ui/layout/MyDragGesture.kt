package com.jw.basics.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/19 16:43
 * @Des  compose中拖动事件
 */
@Composable
fun MyDragGesture() {

    Column(modifier = Modifier.fillMaxSize()) {

        SingleOrientationDraw()

        Spacer(modifier = Modifier.size(50.dp))

        MultiOrientationDraw()
    }

}

/**
 * 多个方向拖拽,需要从底层方法PointInput开始
 */
@Composable
fun MultiOrientationDraw() {
    var offsetX by remember {
        mutableStateOf(0f)
    }
    var offsetY by remember {
        mutableStateOf(0f)
    }

    Text(text = "多个方向拖拽,需要使用pointerInput修饰符,监听拖拽事件.")

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(MaterialTheme.colors.secondary)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                },
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Drag")
        }
    }
}

/**
 * 单个方向拖拽,draggable修饰符中orientation只能设置单个方向.
 */
@Composable
private fun SingleOrientationDraw() {
    var offsetX by remember {
        mutableStateOf(0f)
    }

    Text(text = "单个方向拖拽,需要使用draggable修饰符,但是orientation只能设置单个方向,导致只能单个方向拖拽.")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(30.dp)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset { IntOffset(offsetX.roundToInt(), 0) }
                .background(MaterialTheme.colors.secondary)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        offsetX += delta
                    }

                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Drag")
        }
    }
}