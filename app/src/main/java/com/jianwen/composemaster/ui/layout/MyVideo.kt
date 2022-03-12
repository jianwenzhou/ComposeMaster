package com.jianwen.composemaster.ui.layout

import android.net.Uri
import android.util.Log
import android.widget.VideoView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/12 11:42
 * @Des Compose中使用原生控件，例如mapView，VideoView，webView，还有一些其他的复杂控件，就需要用AndroidView来包裹，从而在
 * Compose中使用原生View控件。
 * 重点就是各个生命周期管理，以及播放按钮等状态提升。
 */
@Composable
fun MyVideo() {
    Box(modifier = Modifier.fillMaxSize()) {
        val uri: Uri = Uri.parse("https://media.w3.org/2010/05/sintel/trailer.mp4")
        PlayVideo(uri)
    }
}

@Composable
private fun PlayVideo(uri: Uri) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onSurface)
    ) {
        Text(
            text = "视频播放",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.surface
        )
        //生命周期管理
        val videoView = getVideoViewBindLifecycle()

        AndroidView(modifier = Modifier.clickable {
            if (videoView.isPlaying) {
                videoView.pause()
            } else {
                videoView.start()
            }
        }, factory = {
            videoView.apply {
                setVideoURI(uri)
                start()
            }
        })
    }
}

/**
 * 创建一个VideoView，和Lifecycle相互绑定
 */
@Composable
fun getVideoViewBindLifecycle(): VideoView {
    val context = LocalContext.current
    val videoView = remember {
        VideoView(context)
    }
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(key1 = lifecycle, key2 = videoView) {
        val lifecycleObserver = getVideoViewLifecycleObserver(videoView)
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }
    return videoView
}

fun getVideoViewLifecycleObserver(videoView: VideoView): LifecycleEventObserver =
    LifecycleEventObserver { _, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
            }
            Lifecycle.Event.ON_START -> {
            }
            Lifecycle.Event.ON_RESUME -> {
                videoView.resume()
                videoView.start()
                Log.d("zjw", "resume")
            }
            Lifecycle.Event.ON_PAUSE -> {
                videoView.pause()
                Log.d("zjw", "pause")
            }
            Lifecycle.Event.ON_STOP -> {
            }
            Lifecycle.Event.ON_DESTROY -> {
                videoView.stopPlayback()
                Log.d("zjw", "destroy")
            }
            else -> throw IllegalStateException()
        }
    }