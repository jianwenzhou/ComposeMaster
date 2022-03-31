package com.jianwen.composemaster.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jianwen.composemaster.data.Const
import com.jianwen.composemaster.data.MainListData

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster
 * @Author jianwen.zhou
 * @Date 2022/3/8 0:11
 * @Des MainViewModel
 */
class MainViewModel : ViewModel() {

    val datas = MutableLiveData<List<MainListData>>()


    init {
        //布局
        datas.value = listOf(
            MainListData(
                "基本布局", listOf(
                    Const.Column,
                    Const.Row,
                    Const.Box,
                    Const.Scaffold,
                    Const.ConstraintLayout,
                    Const.ScrollView,
                )
            ),
            MainListData(
                "常用控件",
                listOf(
                    Const.Text,
                    Const.Icon,
                    Const.Image,
                    Const.Button,
                    Const.TextField,
                    Const.Checkbox,
                    Const.Card,
                    Const.Divider,
                    Const.FloatingActionButtons,
                    Const.ProgressIndicator,
                    Const.RadioButton,
                    Const.Spacer,
                    Const.TabRow,
                    Const.Pager,
                )
            ),
            MainListData(
                "滚动布局", listOf(
                    Const.LazyRow,
                    Const.LazyColumn,
                    Const.LazyVerticalGrid,
                    Const.SwipeToRefreshLayout,
                )
            ),
            MainListData(
                "弹窗", listOf(
                    Const.Dialog,
                    Const.Popup,
                )
            ),
            MainListData(
                "动画", listOf(
                    Const.Animate,
                )
            ),

            MainListData(
                "主题", listOf(
                    Const.Theme,
                )

            ),

            MainListData(
                "隐式传参", listOf(
                    Const.CompositionLocal,
                )
            ),

            MainListData(
                "富文本", listOf(
                    Const.RichText,
                )
            ),

            MainListData(
                "XML布局中使用Compose", listOf(
                    Const.LayoutCompose,
                )
            ),

            MainListData(
                "Compose中使用原生View控件", listOf(
                    Const.Video,
                    Const.WebView,
                )
            ),

            MainListData(
                "Compose中各种手势", listOf(
                    Const.ClickableGesture,
                    Const.DoubleClickableGesture,
                    Const.ScrollGesture,
                    Const.DragGesture,
                    Const.SlideGesture,
                    Const.MultipointGesture,
                )
            ),

            MainListData(
                "Compose中Navigation的使用", listOf(
                    Const.ComposeNavigation,
                )
            ),

            MainListData(
                "Compose的附带效应", listOf(
                    Const.LaunchedEffect,
                    Const.RememberCoroutineScope,
                    Const.RememberUpdateState,
                    Const.DisposableEffect,
                    Const.SideEffect,
                    Const.ProduceState,
                    Const.DerivedState,
                )
            ),

            )
    }
}