package com.jianwen.composemaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.jianwen.composemaster.simple.SimpleActivity
import com.jianwen.composemaster.ui.layout.MainCompose
import com.jianwen.composemaster.ui.theme.ZTheme

class MainActivity : ComponentActivity() {

    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZTheme {
                val observeAsState = model.datas.observeAsState()

                Surface(
                    elevation = 2.dp,
                    color = MaterialTheme.colors.surface,
                ) {
                    MainCompose(observeAsState.value!!) { type ->
                        onItemClick(type)
                    }
                }


            }
        }
    }

    private fun onItemClick(type: String) {
        SimpleActivity.start(context = this, type = type)
    }
}
