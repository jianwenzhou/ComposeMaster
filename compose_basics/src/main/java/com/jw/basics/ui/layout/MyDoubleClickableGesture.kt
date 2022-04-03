package com.jw.basics.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/19 15:34
 * @Des  compose中双击，常按，短按，单击等事件
 */
@Composable
fun MyDoubleClickableGesture() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableSample1()
    }

}

@Composable
fun ClickableSample1() {

    var log by remember {
        mutableStateOf("")
    }

    Text(
        text = "按下,长按,单击,双击",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .size(200.dp)
            .background(MaterialTheme.colors.primary.copy(0.5f))
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        log += "双击]   "
                    },
                    onLongPress = {
                        log += "长按]   "
                    },
                    onPress = {
                        log += "   [按下->"
                    },
                    onTap = {
                        log += "单击]   "
                    })
            })

    Spacer(modifier = Modifier.size(50.dp))

    Text(text = log, modifier = Modifier.verticalScroll(rememberScrollState()))
}