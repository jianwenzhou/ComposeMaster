package com.jw.basics.ui.layout

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/26 22:48
 * @Des SideEffect作用：
 * 1.没有接受key值，所以每次重组，都会执行它的block。
 * 2.主要用于与非Compose管理的对象共享Compose状态。
 * 3.当组件被创建并且被载入组件树时候才会执行。
 */
@Composable
fun MySideEffect() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "SideEffect作用：\n" +
                "1.没有接受key值，所以每次重组，都会执行它的block。\n" +
                "2.主要用于与非Compose管理的对象共享Compose状态。\n" +
                "3.当组件被创建并且被载入组件树时候才会执行。")
    }

    SideEffect {
        Log.d("zjw","SideEffect执行")
    }

}