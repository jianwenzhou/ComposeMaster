package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun MyPopup() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var showPop by remember {
            mutableStateOf(false)
        }

        if (showPop) {
            Popup(
                alignment = Alignment.TopStart,
                offset = IntOffset(0, 0),
                onDismissRequest = { },
                properties = PopupProperties(),
            ) {
                Text(
                    text = "我是Popup",
                    Modifier
                        .padding(20.dp)
                        .background(MaterialTheme.colors.secondary)
                )
            }
        }


        Button(onClick = { showPop = !showPop }) {
            Text(text = if (showPop) "Dismiss" else "Show")
        }
    }
}
