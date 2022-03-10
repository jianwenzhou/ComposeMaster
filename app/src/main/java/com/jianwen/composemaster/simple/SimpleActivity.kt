package com.jianwen.composemaster.simple

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.jianwen.composemaster.data.Const
import com.jianwen.composemaster.ui.theme.ComposeMasterTheme

class SimpleActivity : ComponentActivity() {

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
            ComposeMasterTheme {
                SimpleCompose(type)
            }
        }
    }

    private fun initData(type: String?) {
        val model: SimpleViewModel by viewModels()
        if (type == Const.LazyRow || type == Const.LazyColumn) {
            model.getImageList()
        }
    }


}
