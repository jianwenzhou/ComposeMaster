package com.jw.demo.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jw.demo.R
import com.jw.demo.model.MainViewModel
import com.jw.demo.ui.theme.LocalImages

@Composable
fun HotPage(
    navControllers: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    model: MainViewModel = viewModel()
) {
    LaunchedEffect(key1 = Unit, block = {
        model.getImageList()
    })

    val images = model.imageLiveData.observeAsState(listOf())

    Scaffold(topBar = { Text(text = "生活如此多娇") }) { innerPadding ->
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn{
                items(images.value) { data ->
                    ImageCard(
                        title = data.tags, url = data.largeImageURL, modifier = Modifier
                            .width(300.dp)
                            .height(500.dp)
                            .padding(16.dp)
                    )
                }
            }

            if (images.value.isEmpty()) {
                MyLinearProgressIndicator()
            }

        }

    }

}

@Composable
fun MyLinearProgressIndicator() {
    LinearProgressIndicator(
        modifier = Modifier.size(width = 80.dp, height = 5.dp),
        color = MaterialTheme.colors.primary,
        backgroundColor = MaterialTheme.colors.primary.copy(0.4f)
    )
}

@Composable
fun ImageCard(
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


@Composable
fun HotAppBar() {
    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.height(80.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = R.mipmap.image_test),
            contentDescription = null
        )
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null
            )
        }
    }
}