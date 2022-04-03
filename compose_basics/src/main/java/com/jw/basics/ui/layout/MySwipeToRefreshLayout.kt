package com.jw.basics.ui.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.jw.basics.simple.SimpleViewModel

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/10 22:33
 * @Des  下了刷新控件,需要添加依赖(implementation "com.google.accompanist:accompanist-swiperefresh:0.23.1")
 */
@Composable
fun MySwipeToRefreshLayout() {
    val viewModel: SimpleViewModel = viewModel()
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    SwipeRefresh(
        //刷新状态，为 true 时表示正在刷新，相反则不是正在刷新,
        // rememberSwipeableState会使用默认的动画创建并记住 Swipeable 的状态
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { viewModel.refresh() },//拉刷新时需要执行的操作
    ) {
        MyLazyColumn()
    }
}
