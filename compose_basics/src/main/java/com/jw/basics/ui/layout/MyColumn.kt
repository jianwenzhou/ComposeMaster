package com.jw.basics.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jw.basics.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/8 20:42
 * @Des Column，垂直布局
 */
@Composable
fun MyColumn() {
    Column {
        Image(
            painter = painterResource(id = R.mipmap.main), contentDescription = stringResource(
                R.string.test_image
            )
        )
        Text(text = stringResource(R.string.test_string))
    }
}

@Preview
@Composable
fun MyColumnPreview() {
    MyColumn()
}