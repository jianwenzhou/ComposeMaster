package com.jw.basics.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/27 23:33
 * @Des DerivedState：如果某个状态是从其他状态对象计算或派生得出的，请使用derivedStateOf。作为条件
的状态我们称为条件状态。当任意一个条件状态更新时，结果状态都会重新计算。
 */

@Composable
fun MyDerivedState() {

    val top = listOf("Jetpack", "Compose")

    //列表数据集合
    val allTask = remember { mutableStateListOf<String>() }

    //当key值发生变化，topTask这个状态都会重新获取
    val topTask = remember(key1 = allTask, key2 = top) {
        derivedStateOf {
            allTask.filter {
                top.contains(it)
            }
        }
    }

    //输入框的内容
    val (text, setText) = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "DerivedState：如果某个状态是从其他状态对象计算或派生得出的，请使用derivedStateOf。作为条件" +
                    "的状态我们称为条件状态。当任意一个条件状态更新时，结果状态都会重新计算。"
        )

        Spacer(modifier = Modifier.size(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(value = text, onValueChange = setText)

            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {
                allTask.add(text)
                setText("")
            }) {
                Text(text = "Add")
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        LazyColumn {
            //高优先级
            items(topTask.value) {
                Text(text = it, style = MaterialTheme.typography.h4)
            }

            items(allTask) {
                Text(text = it, style = MaterialTheme.typography.body2)
            }
        }

    }

}