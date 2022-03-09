package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jianwen.composemaster.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 20:42
 * @Des Image展示
 * 常用属性:
 * painter:资源
 * contentScale:类似ImageView的ScaleType
 * alpha:图片透明度
 * modifier.size:大小
 * modifier.clip:裁剪形状
 * modifier.border:边框
 */

@Composable
fun MyImage() {
    //类似scrollView效果
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        Text(text = "本地图片加载", Modifier.padding(8.dp))
        Image(
            painter = painterResource(id = R.mipmap.main),
            contentDescription = "Image",
        )
        Text(text = "本地图片加载-透明度设置", Modifier.padding(8.dp))
        Image(
            painter = painterResource(id = R.mipmap.main),
            contentDescription = "Image",
            alpha = 0.5f
        )
        Text(text = "本地图片加载-contentScale", Modifier.padding(8.dp))
        Image(
            contentScale = ContentScale.Inside,
            painter = painterResource(id = R.mipmap.main),
            contentDescription = "Image",
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray)
        )
        Text(text = "本地图片加载-圆形", Modifier.padding(8.dp))
        Image(
            painter = painterResource(id = R.mipmap.main),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Text(text = "网络图片加载-带占位符", Modifier.padding(8.dp))
        AsyncImage(
            model = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png",
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Image",
            modifier = Modifier
                .size(100.dp)
        )
        Text(text = "网络图片加载-圆形加边框,带占位符", Modifier.padding(8.dp))
        AsyncImage(
            model = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png",
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            contentDescription = "Image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Red)
                .padding(1.dp)
        )
    }

}

@Preview
@Composable
fun MyImagePreview() {
    MyImage()
}