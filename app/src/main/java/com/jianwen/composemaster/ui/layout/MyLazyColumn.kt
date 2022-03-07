package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jianwen.composemaster.data.MainListData

/**
 * @ProjectName ComposeDemo
 * @PackageName com.jianwen.composedemo.ui
 * @Author jianwen.zhou
 * @Date 2022/3/6 0:16
 * @Des 垂直列表
 */

@Composable
fun MyLazyColumn(items: List<MainListData>, onClick: (Int) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items) {
                ItemCard(it.name, Modifier.clickable { onClick(it.id) })
                Divider(thickness = 1.dp, color = MaterialTheme.colors.background)
            }
        }

    }

}

@Composable
fun ItemCard(it: String, modifier: Modifier) {
    Text(text = it, modifier = modifier.padding(16.dp), style = MaterialTheme.typography.h6)
}
