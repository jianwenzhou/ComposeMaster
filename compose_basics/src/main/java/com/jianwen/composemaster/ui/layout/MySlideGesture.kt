package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/19 16:43
 * @Des  compose中滑动事件,使用swipeable
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MySlideGesture() {
    val width = 200.dp

    val squareSize = 100.dp

    //滑动State
    val state = rememberSwipeableState(initialValue = 0)
    //dp转px
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    //锚点
    val anchors = mapOf(0f to 0, sizePx to 1)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "通过swipeable修饰符,可以对子组件进行滑动的方向,锚点,阈值进行设置.")

        Box(
            modifier = Modifier
                .width(width = width)
                .background(MaterialTheme.colors.primary.copy(0.1f))
                .swipeable(
                    state = state,
                    orientation = Orientation.Horizontal,
                    anchors = anchors,
                    thresholds = { from: Int, to: Int -> FractionalThreshold(0.3f) }//阈值,超过30%就滑过去,低于30%就滑回来.
                ),
        ) {

            Box(
                modifier = Modifier
                    .size(squareSize)
                    .offset { IntOffset(state.offset.value.roundToInt(), 0) }
                    .background(MaterialTheme.colors.surface.copy(0.9f))
            )

        }


    }

}
