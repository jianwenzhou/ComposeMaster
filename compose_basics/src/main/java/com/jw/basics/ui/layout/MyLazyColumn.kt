package com.jw.basics.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jw.basics.simple.SimpleViewModel

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
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
