package com.jianwen.composemaster.simple

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.jianwen.composemaster.data.Const
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
        Const.LazyRow -> {
            MyLazyRow()
        }
        Const.LazyColumn -> {
            MyLazyColumn()
        }
        Const.SwipeToRefreshLayout -> {
            MySwipeToRefreshLayout()
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

    }
}






