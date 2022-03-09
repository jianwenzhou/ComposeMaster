package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jianwen.composemaster.data.MainListData

/**
 * @ProjectName ComposeDemo
 * @PackageName com.jianwen.composedemo.ui
 * @Author jianwen.zhou
 * @Date 2022/3/6 0:16
 * @Des 垂直列表
 * LazyColumn:类似垂直滑动的RecyclerView,有懒加载效果.
 * stickyHeader:吸顶效果
 * items:遍历集合,组合item
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyLazyColumn(items: List<MainListData>, onClick: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items.forEach {
                stickyHeader {
                    ListTitle(title = it.title)
                }
                items(it.datas) { data ->
                    ItemCard(data) { name -> onClick(name) }
                    Divider(thickness = 1.dp, color = MaterialTheme.colors.onSurface.copy(0.1f))
                }
            }
        }
    }
}

@Composable
fun ListTitle(title: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colors.onSurface.copy(0.1f))
            .padding(start = 16.dp),
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun ItemCard(name: String, modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onClick(name) }
            .padding(start = 16.dp),
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
        )
    }
}


@Preview
@Composable
fun MyLazyColumnPreview() {
    MyLazyColumn(
        listOf(
            MainListData(
                "PreView",
                listOf(
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                    "11111",
                    "22222",
                )
            ),
        )
    ) {}
}