package com.jw.basics.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val zPrimary = Color(0xffffe082)
val zPrimaryLight = Color(0xffffffb3)
val zPrimaryDark = Color(0xffcaae53)
val zSecondary = Color(0xffff8f00)
val zSecondaryLight = Color(0xffffc046)
val zSecondaryDark = Color(0xffc56000)

val jPrimary = Color(0xffe91e63)
val jPrimaryLight = Color(0xffff6090)
val jPrimaryDark = Color(0xffb0003a)
val jSecondary = Color(0xffef5350)
val jSecondaryLight = Color(0xffff867c)
val jSecondaryDark = Color(0xffb61827)

/**
 * Return the fully opaque color that results from compositing [onSurface] atop [surface] with the
 * given [alpha]. Useful for situations where semi-transparent colors are undesirable.
 */
@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}