package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jianwen.composemaster.R

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jianwen.composemaster.ui.layout
 * @Author jianwen.zhou
 * @Date 2022/3/9 20:42
 * @Des 类似原生View的scrollView
 *      Modifier.verticalScroll 垂直滑动
 *      Modifier.horizontalScroll 横向滑动
 *      底层通过重组实现滑动
 */
@Composable
fun MyScrollView() {

    val scrollState = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {
        RowScroll()

        repeat(100) {
            Text(
                text = stringResource(id = R.string.test_string),
                modifier = Modifier.padding(12.dp)
            )
        }


    }

}

@Composable
private fun RowScroll() {
    val scrollState = rememberScrollState()
    Text(text = "横向滑动", modifier = Modifier.padding(12.dp))
    Row(Modifier.horizontalScroll(scrollState)) {
        repeat(100) {
            Text(
                text = stringResource(id = R.string.test_string),
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}


@Preview
@Composable
fun MyScrollViewPreview(){
    MyScrollView()
}