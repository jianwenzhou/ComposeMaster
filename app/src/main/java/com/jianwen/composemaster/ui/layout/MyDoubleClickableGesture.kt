package com.jianwen.composemaster.ui.layout

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
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
    val current = LocalContext.current
    Text(
        text = "单击，双击，长按，短按",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .size(200.dp)
            .background(MaterialTheme.colors.primary.copy(0.5f))
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        Toast
                            .makeText(current, "双击", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onLongPress = {
                        Toast
                            .makeText(current, "长按", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onPress = {
                        Toast
                            .makeText(current, "短按", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onTap = {
                        Toast
                            .makeText(current, "单击", Toast.LENGTH_SHORT)
                            .show()
                    })
            })
}