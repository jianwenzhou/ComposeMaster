package com.jw.basics.simple

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.unit.dp
import androidx.core.view.children
import com.jw.basics.data.Const
import com.jw.basics.ui.theme.JTheme

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
            JTheme {
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
        if (type == Const.LazyRow
            || type == Const.LazyColumn
            || type == Const.SwipeToRefreshLayout
            || type == Const.LazyVerticalGrid
        ) {
            model.getImageList()
        }
    }

    override fun onResume() {
        super.onResume()
        window.decorView.postDelayed({
            (window.decorView as? ViewGroup)?.let { transverse(it, 1) }
        }, 2000)
    }

    //打印当前窗口层级
    private fun transverse(view: View, index: Int) {
        Log.e("zjw", "第${index}层：" + view)
        if (view is ViewGroup) {
            view.children.forEach { transverse(it, index + 1) }
        }
    }

}
