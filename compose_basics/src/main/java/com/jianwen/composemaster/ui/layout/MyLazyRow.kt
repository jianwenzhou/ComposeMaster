package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.jianwen.composemaster.simple.SimpleViewModel
import com.jianwen.composemaster.ui.theme.LocalImages

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/10 23:13
 * @Des  横向列表懒加载，类似recyclerView,
 * 要点：通过observeAsState，将liveData转为state，然后自动刷新items函数，进行重组。
 * 同时利用observeAsState控制进度条的展示隐藏。
 */

@Composable
fun MyLazyRow(model: SimpleViewModel = viewModel()) {
    val observeAsState = model.imageLiveData.observeAsState(listOf())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow {
            items(observeAsState.value) { data ->
                MyNetImageCard(
                    title = data.tags, url = data.largeImageURL, modifier = Modifier
                        .width(300.dp)
                        .height(500.dp)
                        .padding(16.dp)
                )
            }
        }

        if (observeAsState.value.isEmpty()) {
            MyLinearProgressIndicator()
        }
    }

}

@Composable
fun MyNetImageCard(
    title: String,
    url: String,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit = {}
) {
    Box(
        modifier = modifier,
    ) {
        NetImageCard(
            title = title,
            url = url,
            modifier = Modifier.clickable { onItemClick() }
        )
    }
}

@Composable
fun NetImageCard(title: String, url: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(15.dp),  //shape 圆角
        elevation = 5.dp                    //阴影
    ) {
        AsyncImage(
            model = url,
            placeholder = painterResource(LocalImages.current.lockupLogo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        //拉渐变
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(         //渐变效果
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 50f                       //数据越大黑色越少
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart    //底部位置
        )
        {
            Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
        }
    }
}