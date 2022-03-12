package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jianwen.composemaster.simple.SimpleViewModel

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/10 23:13
 * @Des  竖向列表懒加载，类似recyclerView,
 * 要点：通过observeAsState，将liveData转为state，然后自动刷新items函数，进行重组。
 * 同时利用observeAsState控制进度条的展示隐藏。
 */

@Composable
fun MyLazyColumn(model: SimpleViewModel = viewModel()) {
    val observeAsState = model.imageLiveData.observeAsState(listOf())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn() {
            items(observeAsState.value) { data ->
                MyNetImageCard(data.tags, data.largeImageURL)
            }
        }

        if (observeAsState.value.isEmpty()) {
            MyLinearProgressIndicator()
        }
    }

}
