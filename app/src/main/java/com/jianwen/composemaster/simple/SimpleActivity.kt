package com.jianwen.composemaster.simple

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.unit.dp
import com.jianwen.composemaster.data.Const
import com.jianwen.composemaster.ui.theme.MyComposeTheme

class SimpleActivity : ComponentActivity() {
    private val model: SimpleViewModel by viewModels()

    companion object {
        fun start(context: Context, type: String) {
            val intent = Intent(context, SimpleActivity::class.java)
            intent.putExtra("type", type)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = intent.getStringExtra("type")
        initData(type)
        setContent {
            MyComposeTheme(colors = model.theme) {
                Surface(
                    elevation = 2.dp,
                    color = MaterialTheme.colors.surface,
                ) {
                    SimpleCompose(type)
                }
            }
        }
    }

    private fun initData(type: String?) {
        if (type == Const.LazyRow || type == Const.LazyColumn || type == Const.SwipeToRefreshLayout) {
            model.getImageList()
        }
    }


}
