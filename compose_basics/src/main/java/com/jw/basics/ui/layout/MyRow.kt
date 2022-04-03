package com.jw.basics.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jw.basics.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/8 20:50
 * @Des Row，横向布局
 */
@Composable
fun MyRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
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
fun MyRowPreview(){
    MyRow()
}