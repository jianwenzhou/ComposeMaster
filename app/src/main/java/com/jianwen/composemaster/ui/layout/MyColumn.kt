package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jianwen.composemaster.R

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