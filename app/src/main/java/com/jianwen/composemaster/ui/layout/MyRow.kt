package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.jianwen.composemaster.R

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