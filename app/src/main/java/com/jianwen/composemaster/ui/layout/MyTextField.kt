package com.jianwen.composemaster.ui.layout

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jianwen.composemaster.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/8 20:37
 * @Des 输入框,下面展示三种弹窗,以及获取输入的内容.
 * 要点,输入框需要搭配mutableStateOf使用,将输入的值保存,然后再设置给TextField.不然TextField会不显示文本内容.
 * 详情字段注释在下述代码中
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyTextField() {

    //输入法控制器,用于展示隐藏
    val current = LocalSoftwareKeyboardController.current

    val rememberScrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .clickable { current?.hide() }
            .verticalScroll(rememberScrollState),
    ) {

        val modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.Gray.copy(0.2f))

        TextField1(
            modifier = modifier
        )

        Spacer(modifier = Modifier.size(10.dp))

        TextField2(
            modifier = modifier
        )

        Spacer(modifier = Modifier.size(10.dp))

        TextField3(
            modifier = modifier
        )
    }
}

@Composable
private fun TextField1(modifier: Modifier = Modifier) {
    var text1 by remember { mutableStateOf("") }
    Text(text = text1, modifier = modifier)
    Column(modifier = modifier) {
        TextField(
            placeholder = {//类似Edittext的hint
                Text(
                    text = "请输入",
                    fontSize = 14.sp,
                    color = Color.Gray.copy(0.5f)
                )
            },
            value = text1,                      //展示内容
            onValueChange = { text1 = it },     //输入监听
            label = { Text(text = "密码") },      //输入中的小标题
            isError = text1.length > 10,         //错误提示
            modifier = Modifier.fillMaxWidth(),  //宽度铺满屏幕
            singleLine = true,                  //单行
            leadingIcon = {                     // 前图标
                Image(
                    painter = painterResource(id = R.mipmap.love),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp)
                )
            },
            textStyle = TextStyle(fontSize = 14.sp),//设置文字颜色,大小等等
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),//键盘输入类型
            visualTransformation = PasswordVisualTransformation(),//显示成密码样式
        )
    }
}

@Composable
private fun TextField3(modifier: Modifier = Modifier) {
    val applicationContext = LocalContext.current.applicationContext

    var text3 by remember { mutableStateOf("") }
    Text(text = text3, modifier = modifier)
    Column(modifier = modifier) {
        OutlinedTextField(
            placeholder = { Text(text = "请输入", fontSize = 14.sp, color = Color.Gray.copy(0.5f)) },
            value = text3,
            onValueChange = { text3 = it },
            label = { Text(text = "用户名") },
            isError = text3.length > 10,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            trailingIcon = {  // 后置图标
                Image(
                    painter = painterResource(id = R.mipmap.love),
                    contentDescription = "",
                    modifier = Modifier
                        .size(14.dp)
                        .clickable {
                            Toast
                                .makeText(
                                    applicationContext,
                                    "clickable:后置图标",
                                    Toast.LENGTH_LONG
                                )
                                .show()
                        }
                )
            },
            textStyle = TextStyle(fontSize = 14.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(onSend = {
                Toast.makeText(applicationContext, "onSend:$text3", Toast.LENGTH_LONG).show()
            })
        )
    }
}

@Composable
private fun TextField2(modifier: Modifier = Modifier) {
    var text2 by remember { mutableStateOf("") }
    Text(text = text2, modifier = modifier)
    Column(modifier = modifier) {
        BasicTextField(
            value = text2,
            onValueChange = { text2 = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = TextStyle(fontSize = 14.sp)
        )
    }
}


@Preview
@Composable
fun MyTextFieldPreview() {
    MyTextField()
}