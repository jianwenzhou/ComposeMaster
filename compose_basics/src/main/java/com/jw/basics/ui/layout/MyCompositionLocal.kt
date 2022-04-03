package com.jw.basics.ui.layout

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/13 22:42
 * @Des CompositionLocal:隐式传参，MaterialTheme里面的color，shape等等都是通过staticCompositionLocalOf生成的。
 * 要点1.infix函数 LocalContentAlpha provides ContentAlpha.medium 等于 LocalContentAlpha.provides(ContentAlpha.medium)
 * 要点2.通过CompositionLocalProvider修改LocalContentAlpha,只针对CompositionLocalProvider的域下剩下。
 * 要点3.Compose中已经封装了很多CompositionLocal,例如context,键盘管理,ClipboardManager,lifecycle等等常用的小组件.
 */
val textCompositionLocal = compositionLocalOf { "CompositionLocal" }

@Composable
fun MyCompositionLocal() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {
        //自定义CompositionLocal
        TextCompositionLocalText()
        Spacer(modifier = Modifier.size(20.dp))

        //上下文
        val context = MyLocalContext()
        Spacer(modifier = Modifier.size(20.dp))

        //剪切板
        MyLocalClipboardManager(context)
        Spacer(modifier = Modifier.size(20.dp))

        //输入法
        MyLocalSoftwareKeyboardController()
        Spacer(modifier = Modifier.size(20.dp))

        //生命周期,演示可见MyVideo.kt
        val lifecycle = LocalLifecycleOwner.current.lifecycle

    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun MyLocalSoftwareKeyboardController() {
    val focusRequester = remember { FocusRequester() }
    var textField by remember { mutableStateOf("") }
    TextField(
        value = textField,
        onValueChange = { textField = it },
        modifier = Modifier.focusRequester(focusRequester)
    )
    val keyboard = LocalSoftwareKeyboardController.current
    Button(onClick = {
        focusRequester.requestFocus()
        keyboard?.show()
    }) {
        Text(text = "弹出输入法")
    }
    Button(onClick = {
        keyboard?.hide()
    }) {
        Text(text = "隐藏输入法")
    }
}

@Composable
private fun MyLocalClipboardManager(context: Context) {
    val clipboardManager = LocalClipboardManager.current
    Button(onClick = {
        clipboardManager.setText(AnnotatedString("LocalClipboardManager"))
        Toast.makeText(context, "复制成功:" + clipboardManager.getText(), Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "LocalClipboardManager")
    }
}

@Composable
private fun MyLocalContext(): Context {
    val context = LocalContext.current
    Toast.makeText(context, "LocalContext", Toast.LENGTH_SHORT).show()
    return context
}

@Composable
private fun TextCompositionLocalText() {
    Column {
        ShowText(textCompositionLocal.current)
        CompositionLocalProvider(textCompositionLocal provides "我是CompositionLocal") {
            ShowText(textCompositionLocal.current)
        }
        CompositionLocalProvider(textCompositionLocal provides "CompositionLocal是我") {
            ShowText(textCompositionLocal.current)
        }
        ShowText(textCompositionLocal.current)
    }
}

@Composable
private fun ShowText(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun MyCompositionLocalPreView() {
    MyCompositionLocal()
}
