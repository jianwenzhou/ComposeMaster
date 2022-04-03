package com.jw.basics.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/16 23:34
 * @Des  AlertDialog和Dialog组件,用于Compose中弹窗展示
 */
@Composable
fun MyDialog() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Dialog1()

        Dialog2()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Dialog2() {
    var isShowDialog by remember {
        mutableStateOf(false)
    }
    if (isShowDialog) {
        AlertDialog(
            shape = RoundedCornerShape(8.dp),
            onDismissRequest = { isShowDialog = false },
            title = {
                Text(
                    text = "我是标题",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            },
            text = {
                Text(
                    text = "我是内容", style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            },
            buttons = {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "我是按钮")
                }
            },
            backgroundColor = MaterialTheme.colors.error.copy(0.1f),
            properties = DialogProperties(usePlatformDefaultWidth = true),
        )
    }
    Button(onClick = { isShowDialog = !isShowDialog }) {
        Text(text = if (isShowDialog) "dismiss two" else "show two")
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Dialog1() {
    var isShowDialog by remember {
        mutableStateOf(false)
    }
    if (isShowDialog) {
        Dialog(
            onDismissRequest = {
                isShowDialog = false
            },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            MyCard()
        }
    }

    Button(onClick = { isShowDialog = !isShowDialog }) {
        Text(text = if (isShowDialog) "dismiss one" else "show  one")
    }
}
