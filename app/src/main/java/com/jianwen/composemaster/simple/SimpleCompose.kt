package com.jianwen.composemaster.simple

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.jianwen.composemaster.R
import com.jianwen.composemaster.data.Const
import com.jianwen.composemaster.ui.layout.MyLazyColumn

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.simple
 * @Author jianwen.zhou
 * @Date 2022/3/8 13:37
 * @Des
 */

@Composable
fun SimpleCompose(type: String?) {
    when (type) {
        Const.Column -> {

        }
        Const.Row -> {
            MyRow()
        }
        Const.Box -> {
        }
        Const.Scaffold -> {
        }
        Const.ConstraintLayout -> {
        }
        Const.Text -> {
        }
        Const.Icon -> {
        }
        Const.Image -> {
        }
        Const.Button -> {
        }
        Const.TextField -> {
        }
        Const.Checkbox -> {
        }
        Const.Card -> {
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

@Composable
private fun MyRow() {
    Row() {
        Image(
            painter = painterResource(id = R.mipmap.main), contentDescription = stringResource(
                R.string.test_image
            )
        )

        Text(text = stringResource(R.string.test_string))
    }
}
