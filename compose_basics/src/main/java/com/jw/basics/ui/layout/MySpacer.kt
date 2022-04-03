package com.jw.basics.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jw.basics.R


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.simple
 * @Author jianwen.zhou
 * @Date 2022/3/16 19:37
 * @Des Spacer组件，作用类似margin，由于compose中不能直接设置margin，所以常用Spacer组件作为控件之间的边距
 */

@Composable
fun MySpacer() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.test_string))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = stringResource(id = R.string.test_string))
        Spacer(modifier = Modifier.size(50.dp))
        Text(text = stringResource(id = R.string.test_string))
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = stringResource(id = R.string.test_string))
    }
}