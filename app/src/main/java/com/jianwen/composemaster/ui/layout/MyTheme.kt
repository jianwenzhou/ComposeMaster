package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jianwen.composemaster.R

@Composable
fun MyTheme() {
    Scaffold(
        topBar = { TopBar {} },
        bottomBar = { BottomBar() },
        floatingActionButton = { FloatingButton() },
        modifier = Modifier.fillMaxSize()
    ) {
        MyContent()
    }
}

@Composable
fun MyContent(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth(0.8f),
            shape = RoundedCornerShape(15.dp),  //shape 圆角
            elevation = 20.dp                    //阴影
        ) {
            Column {
                Image(
                    painter = painterResource(
                        id = R.mipmap.main
                    ),
                    contentDescription = "des",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.test_string),
                    style = TextStyle(color = MaterialTheme.colors.onSurface, fontSize = 20.sp)
                )
            }
        }
    }
}

@Composable
fun FloatingButton() {
    FloatingActionButton(onClick = { }) {
        Text(text = "悬浮")
    }
}

@Composable
fun BottomBar() {
    BottomAppBar {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "我是BottomBar")
        }
    }
}

@Composable
fun TopBar(onChangeTheme: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable { onChangeTheme() }
            )
        },
        title = {
            Text(text = "我是TopBar")
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}
