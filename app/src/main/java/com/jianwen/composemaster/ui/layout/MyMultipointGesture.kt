package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/19 16:43
 * @Des  compose中多点触控事件,平移,缩放,旋转
 */
@Composable
fun MyMultipointGesture() {

    //缩放
    var zoom by remember {
        mutableStateOf(1f)
    }

    //位移
    var pan by remember {
        mutableStateOf(
            Offset.Zero
        )
    }

    //旋转
    var rotation by remember {
        mutableStateOf(0f)
    }


    val state =
        rememberTransformableState(onTransformation = { zoomChange, panChange, rotationChange ->
            zoom *= zoomChange
            pan += panChange
            rotation += rotationChange

        })

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier
            .graphicsLayer {
                scaleX = zoom
                scaleY = zoom
                translationX = pan.x
                translationY = pan.y
                rotationZ = rotation
            }
            .transformable(state = state)
            .background(MaterialTheme.colors.secondary)
            .size(150.dp)
        )

    }

}
