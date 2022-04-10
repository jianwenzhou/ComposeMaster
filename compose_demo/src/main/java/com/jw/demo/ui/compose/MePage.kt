package com.jw.demo.ui.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MePage(navControllers: NavHostController, modifier: Modifier) {
    Text(text = "me")
}

