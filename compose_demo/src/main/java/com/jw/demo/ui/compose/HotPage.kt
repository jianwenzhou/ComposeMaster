package com.jw.demo.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jw.demo.R
import com.jw.demo.model.MainViewModel
import com.jw.http.entity.Hit

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
            modifier = modifier
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(innerPadding)
        ) {

            LazyColumn {
                items(images.value) { data ->
                    ImageCard(data)
                }
            }

        }

    }

}

@Composable
fun ImageCard(data: Hit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .padding(20.dp)
    ) {
        Box {
            AsyncImage(
                model = data.largeImageURL,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(//渐变效果
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
            ) {
                Text(
                    text = data.tags,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .align(
                            Alignment.Center
                        )
                        .padding(12.dp)
                )
            }
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