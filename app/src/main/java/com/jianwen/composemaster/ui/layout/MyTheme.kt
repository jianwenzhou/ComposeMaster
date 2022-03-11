package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jianwen.composemaster.R
import com.jianwen.composemaster.simple.SimpleViewModel
import com.jianwen.composemaster.ui.theme.OwlTheme
import kotlinx.coroutines.launch

@Composable
fun MyTheme(viewModel: SimpleViewModel = viewModel()) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scaffoldState) { viewModel.changeTheme() } },
        bottomBar = { BottomBar() },
        drawerContent = { DrawerContent() },
        floatingActionButton = { FloatingButton() },
        modifier = Modifier.fillMaxSize(),
        drawerShape = RoundedCornerShape(0),
    ) {
        MyContent()
    }
}

@Composable
fun DrawerContent() {
    MyAnimate()
}

@Composable
fun MyContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            shape = RoundedCornerShape(15.dp),  //shape 圆角
            elevation = 20.dp                    //阴影
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                    modifier = Modifier.padding(5.dp),
                    text = stringResource(id = R.string.test_string),
                    style = TextStyle(color = OwlTheme.colors.onSurface, fontSize = 20.sp)
                )
            }
        }
    }
}

@Composable
fun FloatingButton() {
    FloatingActionButton(onClick = { }) {
        Text(text = "悬浮", style = TextStyle(color = OwlTheme.colors.onSurface, fontSize = 12.sp))
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
            Text(
                text = "我是BottomBar",
                style = TextStyle(color = OwlTheme.colors.onSurface, fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun TopBar(scaffoldState: ScaffoldState, onChangeTheme: () -> Unit) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch { scaffoldState.drawerState.open() }
                }
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "Localized description")
            }
        },
        title = {
            Text(
                text = "我是TopBar",
                style = TextStyle(color = OwlTheme.colors.onSurface, fontSize = 20.sp)
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
            IconButton(
                onClick = {
                    onChangeTheme()
                }
            ) {
                Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
            }
        }
    )
}
