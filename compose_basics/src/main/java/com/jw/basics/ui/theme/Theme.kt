package com.jw.basics.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.jw.basics.R

val zThemeLight = lightColors(
    primary = zPrimary,
    primaryVariant = zPrimaryLight,
    secondary = zSecondary,
    secondaryVariant = zSecondaryLight
)

val zThemeDark = darkColors(
    primary = zPrimary,
    primaryVariant = zPrimaryDark,
    secondary = zSecondary,
    secondaryVariant = zSecondaryDark
)

@Composable
fun ZTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        zThemeDark
    } else {
        zThemeLight
    }
    MyComposeTheme(darkTheme, colors, content)
}


val jThemeLight = lightColors(
    primary = jPrimary,
    primaryVariant = jPrimaryLight,
    secondary = jSecondary,
    secondaryVariant = jSecondaryLight
)

val jThemeDark = darkColors(
    primary = jPrimary,
    primaryVariant = jPrimaryDark,
    secondary = jSecondary,
    secondaryVariant = jSecondaryDark
)

@Composable
fun JTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        jThemeDark
    } else {
        jThemeLight
    }
    MyComposeTheme(darkTheme, colors, content)
}

private val LightElevation = Elevations()

private val DarkElevation = Elevations(card = 1.dp)

private val LightImages = Images(lockupLogo = R.drawable.ic_drak)

private val DarkImages = Images(lockupLogo = R.drawable.ic_light)

private val LightColors = MyColors(jSecondaryLight,jSecondaryLight,jSecondaryLight)

private val DarkColors = MyColors(jSecondaryDark,jSecondaryDark,jSecondaryDark)

@Composable
fun MyComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: Colors,
    content: @Composable () -> Unit
) {
    val elevation = if (darkTheme) DarkElevation else LightElevation
    val images = if (darkTheme) DarkImages else LightImages
    val color = if (darkTheme) DarkColors else LightColors
    //compose中非常重要的隐式传参,在MaterialTheme包裹下,都可以通过LocalImages.current.lockupLogo获取到值!!!
    CompositionLocalProvider(
        LocalElevations provides elevation,
        LocalImages provides images ,
        LocalColor provides color
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = Shapes,
            content = content
        )
    }
}

