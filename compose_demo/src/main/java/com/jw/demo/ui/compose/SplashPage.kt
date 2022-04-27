package com.jw.demo.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jw.demo.model.MainViewModel
import com.jw.http.entity.WeatherEntity

@Composable
fun SplashPage(
    loadSplashPageData: () -> Unit = {},
    actions: () -> Unit = {},
    model: MainViewModel = viewModel()
) {
    val weatherState = model.weatherLiveData.observeAsState()

    LaunchedEffect(key1 = Unit, block = {
        loadSplashPageData()
    })

    Box(modifier = Modifier.fillMaxSize()) {

        Text(
            text = weatherState.value?.result?.future?.first()?.weather ?: "",
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = {
                //关闭闪屏页，展示主页
                loadSplashPageData()
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.dp)
        ) {
            Text(text = "跳过")
        }


    }
}