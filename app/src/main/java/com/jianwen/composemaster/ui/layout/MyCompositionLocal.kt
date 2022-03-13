package com.jianwen.composemaster.ui.layout

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/13 22:42
 * @Des CompositionLocal:隐式传参，MaterialTheme里面的color，shape等等都是通过staticCompositionLocalOf生成的。
 * 要点1.infix函数 LocalContentAlpha provides ContentAlpha.medium 等于 LocalContentAlpha.provides(ContentAlpha.medium)
 * 要点2.通过CompositionLocalProvider修改LocalContentAlpha,只针对CompositionLocalProvider的域下剩下。
 * 要点3.Compose中已经封装了很多CompositionLocal,例如context,键盘管理,ClipboardManager,lifecycle等等常用的小组件.
 */
val textCompositionLocal = compositionLocalOf { "CompositionLocal" }

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyCompositionLocal() {
    Column {
        //自定义CompositionLocal
        TextCompositionLocalText()

        //剪切板
        val clipboardManager = LocalClipboardManager.current
        Button(onClick = { clipboardManager.setText(AnnotatedString("LocalClipboardManager")) }) {
            Text(text = "LocalClipboardManager")
        }


        //输入法
        val keyboard = LocalSoftwareKeyboardController.current
        Button(onClick = { keyboard?.show() }) {
            Text(text = "弹出输入法")
        }

        //生命周期
        val lifecycle = LocalLifecycleOwner.current.lifecycle


        //上下文
        val context = LocalContext.current
        Toast.makeText(context, "LocalContext", Toast.LENGTH_SHORT).show()

    }
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
