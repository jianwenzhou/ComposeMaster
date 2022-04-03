package com.jw.basics.original

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jw.basics.databinding.ActivityOriginalBinding
import com.jw.basics.ui.layout.MyScaffold

/**
 * 这块代码演示,在layout布局中,使用Compose组件功能.通过androidx.compose.ui.platform.ComposeView控件.
 */
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