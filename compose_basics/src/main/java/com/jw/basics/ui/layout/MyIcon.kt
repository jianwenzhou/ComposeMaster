package com.jw.basics.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 20:42
 * @Des Icon,不同于Image,常用于首页底部导航栏等位置,可以设置颜色.仅支持矢量图和png,jpg.默认是黑色.
 */

@Composable
fun MyIcon() {
    Column {
        Icon(
            imageVector = Icons.Outlined.Call,
            contentDescription = "Icon",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp),
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Icon(
            imageVector = Icons.Outlined.Call,
            contentDescription = "Icon",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp),
            tint = Color.Blue
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Icon(
            imageVector = Icons.Outlined.Call,
            contentDescription = "Icon",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp),
            tint = Color.Red
        )
    }

}

@Preview
@Composable
fun MyIconPreview() {
    MyIcon()
}