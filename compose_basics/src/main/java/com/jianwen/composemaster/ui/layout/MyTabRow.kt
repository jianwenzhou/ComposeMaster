package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.simple
 * @Author jianwen.zhou
 * @Date 2022/3/16 19:45
 * @Des TabRow组件，常搭配Pager使用。类似原生view中的TabLayout.
 */

@Composable
fun MyTabRow() {

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.onBackground.copy(0.1f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = selectedIndex,
        ) {
            HomeTab(0, "热门", selectedIndex) { selectedIndex = it }
            HomeTab(1, "推荐", selectedIndex) { selectedIndex = it }
            HomeTab(2, "直播", selectedIndex) { selectedIndex = it }
            HomeTab(3, "要闻", selectedIndex) { selectedIndex = it }
        }

        MyTabContent(selectedIndex)

    }
}

@Composable
fun MyTabContent(selectedIndex: Int) {
    val padding = Modifier.padding(20.dp)
    when (selectedIndex) {
        0 -> {
            Text(text = "热门内容", modifier = padding, color = MaterialTheme.colors.secondary)
        }
        1 -> {
            Text(text = "推荐内容", modifier = padding, color = MaterialTheme.colors.secondary)
        }
        2 -> {
            Text(text = "直播内容", modifier = padding, color = MaterialTheme.colors.secondary)
        }
        3 -> {
            Text(text = "要闻内容", modifier = padding, color = MaterialTheme.colors.secondary)
        }
    }

}

/**
 * @param index Tab默认的唯一index
 * @name index Tab 名称
 * @name selectedIndex Tab 当前选中的index
 * @name onClick 点击回调，修改selectedIndex数据，重组组件。
 */
@Composable
fun HomeTab(index: Int, name: String, selectedIndex: Int, onClick: (Int) -> Unit) {
    Tab(
        selected = selectedIndex == index,
        onClick = { onClick(index) },
        selectedContentColor = MaterialTheme.colors.secondary,
        unselectedContentColor = MaterialTheme.colors.onSecondary
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.subtitle2
        )
    }
}
