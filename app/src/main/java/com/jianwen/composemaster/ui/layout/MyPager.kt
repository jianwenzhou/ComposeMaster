package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.simple
 * @Author jianwen.zhou
 * @Date 2022/3/16 19:45
 * @Des HorizontalPager组件，水平滑动，类似原生View中的ViewPager。
 * VerticalPager组件，垂直滑动，类似原生View中的ViewPager2中，设置垂直滑动的效果。
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyPager() {
    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = 4,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> {
                    NewsPage()
                }
                1 -> {
                    MoviePage()
                }
                2 -> {
                    PicturePage()
                }
                3 -> {
                    MusicPage()
                }
            }
        }
    }

}

@Composable
fun MusicPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red.copy(0.1f)),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "MusicPage", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun PicturePage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue.copy(0.1f)),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "PicturePage", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun MoviePage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow.copy(0.1f)),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "MoviePage", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun NewsPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green.copy(0.1f)),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "NewsPage", style = MaterialTheme.typography.subtitle1)
    }
}
