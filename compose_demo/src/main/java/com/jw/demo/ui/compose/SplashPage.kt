package com.jw.demo.ui.compose

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jw.demo.model.MainViewModel

@Composable
fun SplashPage(
    loadSplashPageData: () -> Unit = {},
    actions: () -> Unit = {},
    model: MainViewModel = viewModel()
) {

    val weatherState = model.weatherLiveData.observeAsState()

    val weatherText = remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = Unit, block = {
        //采用这种方法参数，不知道为啥无法更新到数据。
        //loadSplashPageData()
        model.getSimpleWeather("深圳")
    })

    weatherText.value = weatherState.value?.result?.let {
        it.city + "\n" + it.future[0].date + "\n" + it.future[0].weather + "\n" +
                it.future[0].temperature + "\n" + "遇见你很美好"
    } ?: ""

    Log.d("zjw", "weatherState" + weatherState.value)

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = weatherText.value,
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colors.background,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = {
                //关闭闪屏页，展示主页
                actions()
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.dp)
        ) {
            Text(text = "跳过")
        }


    }
}