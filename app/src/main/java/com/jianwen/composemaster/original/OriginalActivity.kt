package com.jianwen.composemaster.original

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.jianwen.composemaster.databinding.ActivityOriginalBinding
import com.jianwen.composemaster.ui.layout.MyCard

class OriginalActivity : Activity() {

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


        binding.composeView.setContent {
            MyCard()
        }

    }
}