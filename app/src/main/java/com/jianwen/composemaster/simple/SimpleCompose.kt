package com.jianwen.composemaster.simple

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.jianwen.composemaster.data.Const
import com.jianwen.composemaster.original.OriginalActivity
import com.jianwen.composemaster.ui.layout.*

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.simple
 * @Author jianwen.zhou
 * @Date 2022/3/8 20:37
 * @Des 各个组件详情页面
 */

@Composable
fun SimpleCompose(type: String?) {
    when (type) {
        Const.Column -> {
            MyColumn()
        }
        Const.Row -> {
            MyRow()
        }
        Const.Box -> {
            MyBox()
        }
        Const.Scaffold -> {
            MyScaffold()
        }
        Const.ConstraintLayout -> {
            MyConstraintLayout()
        }
        Const.ScrollView -> {
            MyScrollView()
        }
        Const.Text -> {
            MyText()
        }
        Const.Icon -> {
            MyIcon()
        }
        Const.Image -> {
            MyImage()
        }
        Const.Button -> {
            MyButton()
        }
        Const.TextField -> {
            MyTextField()
        }
        Const.Checkbox -> {
            MyCheckbox()
        }
        Const.Card -> {
            MyCard()
        }
        Const.Divider -> {
            MyDivider()
        }
        Const.FloatingActionButtons -> {
            MyFloatingActionButtons()
        }
        Const.ProgressIndicator -> {
            MyProgressIndicator()
        }
        Const.RadioButton -> {
            MyRadioButton()
        }
        Const.Spacer -> {
            MySpacer()
        }
        Const.TabRow -> {
            MyTabRow()
        }
        Const.Pager -> {
            MyPager()
        }
        Const.LazyRow -> {
            MyLazyRow()
        }
        Const.LazyColumn -> {
            MyLazyColumn()
        }
        Const.LazyVerticalGrid -> {
            MyLazyVerticalGrid()
        }
        Const.SwipeToRefreshLayout -> {
            MySwipeToRefreshLayout()
        }
        Const.Dialog -> {
            MyDialog()
        }
        Const.Animate -> {
            MyAnimate()
        }
        Const.Theme -> {
            MyTheme()
        }
        Const.Video -> {
            MyVideo()
        }
        Const.WebView -> {
            val state = rememberWebViewState(url = "https://developer.android.google.cn/")
            MyWebView(state = state, captureBackPresses = true)
        }
        Const.CompositionLocal -> {
            MyCompositionLocal()
        }
        Const.RichText -> {
            MyRichText()
        }
        Const.LayoutCompose -> {
            OriginalActivity.start(LocalContext.current)
        }

        Const.ClickableGesture -> {
            MyClickableGesture()
        }
        Const.DoubleClickableGesture -> {
            MyDoubleClickableGesture()
        }
        Const.ScrollGesture -> {
        }
        Const.DragGesture -> {
        }
        Const.SlideGesture -> {
        }
        Const.MultipointGesture -> {
        }

    }
}













