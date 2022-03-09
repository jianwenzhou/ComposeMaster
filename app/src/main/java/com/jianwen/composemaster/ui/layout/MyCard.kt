package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 20:42
 * @Des Icon,不同于Image,常用于首页底部导航栏等位置,可以设置颜色.仅支持矢量图和png,jpg.默认是黑色.
 */
@Composable
fun MyCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp)
    ) {
        ShowImageCard(title = title, des = des, painter = painter)
    }
}


@Composable
fun ShowImageCard(title: String, des: String, painter: Painter, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {

        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = des,
                contentScale = ContentScale.Crop
            )
            //拉渐变
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f//数据越大黑色越少
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomStart
            )
            {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}
