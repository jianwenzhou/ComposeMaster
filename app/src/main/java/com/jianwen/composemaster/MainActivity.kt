package com.jianwen.composemaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.livedata.observeAsState
import com.jianwen.composemaster.simple.SimpleActivity
import com.jianwen.composemaster.ui.layout.MainCompose
import com.jianwen.composemaster.ui.theme.ComposeMasterTheme

class MainActivity : ComponentActivity() {

    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMasterTheme {
                val observeAsState = model.datas.observeAsState()
                MainCompose(observeAsState.value!!) { type ->
                    onItemClick(type)
                }
            }
        }
    }

    private fun onItemClick(type: String) {
        SimpleActivity.start(context = this, type = type)
    }
}
