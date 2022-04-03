package com.jw.basics.ui.theme


import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * 测试使用,自定义颜色,突破MaterialTheme中的限制
 */
@Immutable
data class MyColors(val textColor1: Color, val textColor2: Color, val textColor3: Color)

/**
 * internal 限制了跨 module 的方法的使用
 */
internal val LocalColor = staticCompositionLocalOf<MyColors> {
    error("No LocalColor specified")
}