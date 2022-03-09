package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jianwen.composemaster.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 20:42
 * @Des 按钮,点击默认水波纹效果
 */
@Composable
fun MyButton() {
    val btnValue = remember {
        mutableStateOf("点击此处")
    }
    val count = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize().clickable {  },
        verticalArrangement = Arrangement.Center                //子控件垂直居中
    ) {
        //文本点击按钮
        Button(
            onClick = {
                count.value++
                btnValue.value = "点击了 ${count.value} 次"
            },
            modifier = Modifier//修饰符
                .height(50.dp)
                .width(200.dp)
                .align(Alignment.CenterHorizontally),                //控件水平居中
            enabled = true,                                           //是否启用
            elevation = ButtonDefaults.elevation(4.dp, 8.dp, 2.dp),   //按钮正视图高度，类似阴影这种效果，体现层次感
            shape = RoundedCornerShape(8.dp),                         //圆角
            border = BorderStroke(2.dp, Color.Red),                   //边框
            contentPadding = ButtonDefaults.ContentPadding,           //内容填充
        ) {
            Text(
                text = btnValue.value                               //文本内容
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        //图片点击按钮
        Button(
            onClick = {
                count.value++
                btnValue.value = "点击了 ${count.value} 次"
            },
            modifier = Modifier//修饰符
                .height(50.dp)
                .width(200.dp)
                .align(Alignment.CenterHorizontally),                //控件水平居中
            enabled = true,                                           //是否启用
            elevation = ButtonDefaults.elevation(4.dp, 8.dp, 2.dp),   //按钮正视图高度，类似阴影这种效果，体现层次感
            shape = RoundedCornerShape(8.dp),                         //圆角
            border = BorderStroke(2.dp, Color.Red),                   //边框
            contentPadding = ButtonDefaults.ContentPadding,           //内容填充
        ) {
            Image(
                painter = painterResource(id = R.mipmap.main),
                contentDescription = "Image",
                alpha = 0.5f
            )
        }


    }
}

@Preview
@Composable
fun MyButtonPreview() {
    MyButton()
}