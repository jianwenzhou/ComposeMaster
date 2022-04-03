package com.jw.basics.ui.layout

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jw.basics.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 20:42
 * @Des 要点:需要使用mutableStateOf,对check的值进行存储,从而重组Check的状态
 */
@Composable
fun MyCheckbox() {
    val applicationContext = LocalContext.current.applicationContext
    var isCheck by remember { mutableStateOf(false) }
    SharedPrefsToggle(text = stringResource(id = R.string.test_string), isCheck) {
        isCheck = it
        Toast.makeText(applicationContext, "isCheck:$isCheck", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun SharedPrefsToggle(
    text: String,
    value: Boolean,
    onValueChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,//控件垂直居中
        horizontalArrangement = Arrangement.Center//控件水平居中
    ) {
        Checkbox(checked = value, onCheckedChange = onValueChanged)
        Spacer(modifier = Modifier.size(5.dp))
        Text(text)
    }
}