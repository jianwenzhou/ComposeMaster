package com.jw.basics.simple

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.jw.basics.data.Const
import com.jw.basics.original.OriginalActivity
import com.jw.basics.ui.layout.*

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.basics.simple
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
        Const.Popup -> {
            MyPopup()
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
            MyWebView()
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
            MyScrollGesture()
        }
        Const.DragGesture -> {
            MyDragGesture()
        }
        Const.SlideGesture -> {
            MySlideGesture()
        }
        Const.MultipointGesture -> {
            MyMultipointGesture()
        }
        Const.ComposeNavigation -> {
            MyNavHost()
        }
        Const.LaunchedEffect -> {
            MyLaunchedEffect()
        }
        Const.RememberCoroutineScope -> {
            MyRememberCoroutineScope()
        }
        Const.RememberUpdateState -> {
            MyRememberUpdateState()
        }
        Const.DisposableEffect -> {
            MyDisposableEffect(OnBackPressedDispatcher())
        }
        Const.SideEffect -> {
            MySideEffect()
        }
        Const.ProduceState -> {
            MyProduceState()
        }
        Const.DerivedState -> {
            MyDerivedState()
        }

    }
}


















