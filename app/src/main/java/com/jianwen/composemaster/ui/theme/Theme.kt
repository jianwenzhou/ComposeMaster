package com.jianwen.composemaster.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jianwen.composemaster.R

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

@Composable
fun MyComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: Colors,
    content: @Composable () -> Unit
) {
    val elevation = if (darkTheme) DarkElevation else LightElevation
    val images = if (darkTheme) DarkImages else LightImages
    //compose中非常重要的隐式传参,在MaterialTheme包裹下,都可以通过LocalImages.current.lockupLogo获取到值!!!
    CompositionLocalProvider(
        LocalElevations provides elevation,
        LocalImages provides images
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = Shapes,
            content = content
        )
    }
}

/**
 * Alternate to [MaterialTheme] allowing us to add our own theme systems (e.g. [Elevations]) or to
 * extend [MaterialTheme]'s types e.g. return our own [Colors] extension
 */
object OwlTheme {

    /**
     * Proxy to [MaterialTheme]
     */
    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    /**
     * Proxy to [MaterialTheme]
     */
    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    /**
     * Proxy to [MaterialTheme]
     */
    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    /**
     * Retrieves the current [Elevations] at the call site's position in the hierarchy.
     */
    val elevations: Elevations
        @Composable
        get() = LocalElevations.current

    /**
     * Retrieves the current [Images] at the call site's position in the hierarchy.
     */
    val images: Images
        @Composable
        get() = LocalImages.current
}

