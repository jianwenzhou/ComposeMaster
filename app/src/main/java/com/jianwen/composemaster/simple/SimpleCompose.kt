package com.jianwen.composemaster.simple

import androidx.compose.runtime.Composable
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
        }
        Const.FloatingActionButtons -> {
        }
        Const.ProgressIndicator -> {
        }
        Const.RadioButton -> {
        }
        Const.LazyRow -> {
        }
        Const.LazyColumn -> {
        }

    }
}


