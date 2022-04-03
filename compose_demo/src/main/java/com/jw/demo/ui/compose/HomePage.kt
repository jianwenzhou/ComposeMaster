package com.jw.demo.ui.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun HomePage(navControllers: NavHostController) {
    Text(text = "home")
}