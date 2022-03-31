package com.jianwen.composemaster.ui.layout

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jianwen.composemaster.R


/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 23:42
 * @Des FloatingActionButton，悬浮按钮。
 */
@Composable
fun MyFloatingActionButtons() {

    val applicationContext = LocalContext.current.applicationContext
    Box(modifier = Modifier.fillMaxSize().padding(20.dp), contentAlignment = Alignment.BottomEnd) {
        FloatingActionButton(
            modifier = Modifier.size(80.dp),
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 20.dp,
                pressedElevation = 20.dp
            ),
            backgroundColor = MaterialTheme.colors.primary,
            onClick = {
                Toast.makeText(
                    applicationContext,
                    "点击了FloatingActionButton",
                    Toast.LENGTH_SHORT
                ).show()
            },
        ) {
            //悬浮按钮中的控件,compose中Button都是如此做法,
            // Button类似个可点击的容器,具体展示会回调给用户自定义实现.
            Image(
                painter = painterResource(id = R.mipmap.love),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }

    }

}