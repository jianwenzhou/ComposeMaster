package com.jianwen.composemaster.original

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jianwen.composemaster.databinding.ActivityOriginalBinding
import com.jianwen.composemaster.ui.layout.MyCard
import com.jianwen.composemaster.ui.layout.MyScaffold

class OriginalActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, OriginalActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityOriginalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //直接通过setContent函数，使用Compose组件
        binding.composeView.setContent {
            MyScaffold()
        }

    }
}