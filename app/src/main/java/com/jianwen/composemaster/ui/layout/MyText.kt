package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jianwen.composemaster.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/8 21:42
 * @Des Text，原生View的TextView
 */
@Composable
fun MyText() {
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .horizontalScroll(scrollState)
    ) {
        Text(
            text = stringResource(id = R.string.test_string),
            modifier = Modifier.padding(8.dp),
            fontSize = 8.sp,
            color = colors.onSurface.copy(0.1f)
        )
        Text(
            text = stringResource(id = R.string.test_string),
            modifier = Modifier.padding(8.dp),
            fontSize = 12.sp,
            color = colors.onSurface.copy(0.2f)
        )
        Text(
            text = stringResource(id = R.string.test_string) + "-对齐方式",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            fontSize = 16.sp,
            color = colors.onSurface.copy(0.3f),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.test_string) + "-加粗",
            modifier = Modifier.padding(8.dp),
            fontSize = 20.sp,
            color = colors.onSurface.copy(0.4f),
            //粗体
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.test_string) + "-下划线",
            modifier = Modifier.padding(8.dp),
            fontSize = 24.sp,
            color = colors.onSurface.copy(0.5f),
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = stringResource(id = R.string.test_string) + "-Ellipsis",
            modifier = Modifier.padding(8.dp),
            fontSize = 28.sp,
            color = colors.onSurface.copy(0.6f),
            //超出..展示
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        Text(
            text = stringResource(id = R.string.test_string) + "-默认文字样式",
            modifier = Modifier.padding(8.dp),
            //文字样式
            style = MaterialTheme.typography.h4
        )
    }
}

@Preview
@Composable
fun MyTextPreview() {
    MyText()
}