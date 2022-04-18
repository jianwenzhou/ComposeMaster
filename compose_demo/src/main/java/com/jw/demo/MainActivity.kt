package com.jw.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.jw.demo.model.MainViewModel
import com.jw.demo.ui.compose.MainCompose
import com.jw.demo.ui.theme.ComposeMasterTheme
import com.jw.demo.utils.LocationUtils

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMasterTheme {
                MainCompose(finishActivity = {
                    finish()
                }, loadSplashPageData = {
                    //获取位置信息
                    val locations = LocationUtils.getLocations(this)
                    //获取天气信息,裁剪掉 市 字
                    val city = locations.substring(0, locations.length - 1)
                    viewModel.getSimpleWeather(city)
                })
            }
        }
    }
}