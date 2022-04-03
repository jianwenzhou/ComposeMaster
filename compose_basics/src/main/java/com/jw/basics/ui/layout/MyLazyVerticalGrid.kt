package com.jw.basics.ui.layout

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jw.basics.simple.SimpleViewModel


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/16 23:34
 * @Des  LazyVerticalGrid组件,类似垂直的GridView
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyLazyVerticalGrid(model: SimpleViewModel = viewModel()) {

    val observeAsState = model.imageLiveData.observeAsState(listOf())

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier.padding(horizontal = 10.dp),
            content = {
                items(observeAsState.value) { data ->
                    MyNetImageCard(
                        title = data.tags,
                        url = data.largeImageURL,
                        modifier = Modifier
                            .width(100.dp)
                            .height(150.dp)
                            .padding(5.dp)
                    ) {
                        Toast.makeText(context, data.tags, Toast.LENGTH_SHORT).show()
                    }
                }
            })

        if (observeAsState.value.isEmpty()) {
            MyLinearProgressIndicator()
        }
    }
}