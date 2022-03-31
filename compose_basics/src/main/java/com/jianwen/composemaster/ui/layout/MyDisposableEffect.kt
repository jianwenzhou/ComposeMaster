package com.jianwen.composemaster.ui.layout

import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/24 23:25
 * @Des DisposableEffect:也是一个可组合函数，当DisposableEffect的key发生变化
 * 或者组合函数离开组件树的时候，会取消之前启动的协程，同时会在取消协程前用其
 * 回收方法进行资源相关的回收，可以对一些资源进行清理。
 */
@Composable
fun MyDisposableEffect(backDispatcher: OnBackPressedDispatcher) {

    var isOpen by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Row {
            Switch(checked = isOpen, onCheckedChange = { isOpen = !isOpen })

            Text(text = if (isOpen) "拦截返回键" else "不拦截返回键")

        }

    }

    val current = LocalContext.current
    if (isOpen) {
        DisposableHandle(backDispatcher) {
            Toast.makeText(current, "拦截返回键", Toast.LENGTH_SHORT).show()
        }
    }
}


@Composable
fun DisposableHandle(backDispatcher: OnBackPressedDispatcher, onBack: () -> Unit) {
    val current = LocalContext.current
    //从Activity中传进来的返回按键管理类，可以用于拦截返回键事件。
    val onBackCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //拦截返回按键后，调用onBack函数
                onBack()
            }
        }
    }

    DisposableEffect(key1 = Unit, effect = {
        backDispatcher.addCallback(onBackCallback)
        onDispose {
            Toast.makeText(current, "DisposableHandle组合函数离开组件树", Toast.LENGTH_SHORT).show()
            onBackCallback.remove()
        }
    })

}
