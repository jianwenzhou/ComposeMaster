package com.jw.basics.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/10 23:04
 * @Des RadioButton
 */

@Composable
fun MyRadioButton() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        //记录RadioButton状态
        var isSelected1 by remember {
            mutableStateOf(false)
        }
        RadioButton(selected = isSelected1, onClick = {
            isSelected1 = !isSelected1
        })

        var isSelected2 by remember {
            mutableStateOf(false)
        }
        RadioButton(selected = isSelected2, onClick = {
            isSelected2 = !isSelected2
        })


        RadioButton(selected = isSelected2,enabled = false, onClick = {
            isSelected2 = !isSelected2
        })


    }

}