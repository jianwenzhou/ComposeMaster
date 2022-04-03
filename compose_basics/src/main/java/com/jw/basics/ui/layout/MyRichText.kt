package com.jw.basics.ui.layout

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/15 20:42
 * @Des 富文本.详情字段看下面代码
 * 要点1：通过buildAnnotatedString创建一个富文本string
 * 要点2：通过append函数添加文本，通过withStyle设置文本样式
 * 要点3：通过pushStringAnnotation添加点击事件,pushStringAnnotation要在append方法之前使用。
 * 要点4：富文本点击，需要结合ClickableText来使用
 */

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MyRichText() {
    val text = buildAnnotatedString {
        append("海客谈瀛洲，烟涛微茫信难求。")
        withStyle(
            SpanStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                background = MaterialTheme.colors.surface
            )
        ) {
            append("越人语天姥，云霞明灭或可睹。")
        }

        withStyle(
            SpanStyle(
                color = MaterialTheme.colors.error,
                fontSize = 22.sp,
                fontWeight = FontWeight.Thin,
                background = MaterialTheme.colors.primaryVariant
            )
        ) {
            append("天姥连天向天横，势拔五岳掩赤城。")
        }

        withStyle(
            SpanStyle(
                color = MaterialTheme.colors.secondary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                background = MaterialTheme.colors.onPrimary,
                baselineShift = BaselineShift.Subscript
            )
        ) {
            pushStringAnnotation("onClickOne", annotation = "点击事件1")
            append("天姥连天向天横，势拔五岳掩赤城。")
        }

        withStyle(
            SpanStyle(
                color = MaterialTheme.colors.secondary,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                background = MaterialTheme.colors.primaryVariant,
                baselineShift = BaselineShift.Subscript,
                letterSpacing = TextUnit(2.0f, TextUnitType.Sp)
            )
        ) {
            pushStringAnnotation("onClickTwo", annotation = "点击事件2")
            append("天台四万八千丈，对此欲倒东南倾。")
        }


    }
    val current = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        ClickableText(text = text, onClick = {
            text.getStringAnnotations(tag = "onClickOne", start = it, end = it)
                .firstOrNull()
                ?.let {
                    Toast.makeText(current, "天姥连天向天横，势拔五岳掩赤城。", Toast.LENGTH_SHORT).show()
                }
            text.getStringAnnotations(tag = "onClickTwo", start = it, end = it)
                .firstOrNull()
                ?.let {
                    Toast.makeText(current, "天台四万八千丈，对此欲倒东南倾。", Toast.LENGTH_SHORT).show()
                }
        })
    }

}
