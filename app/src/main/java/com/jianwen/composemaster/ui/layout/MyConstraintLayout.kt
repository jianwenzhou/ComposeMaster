package com.jianwen.composemaster.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jianwen.composemaster.R



@Composable
fun MyConstraintLayout() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        //通过createRefs创建三个引用
        val (imageRef, nameRef, descRef) = createRefs()

        Image(painter = painterResource(id = R.mipmap.main),
            contentDescription = "dog avatar",
            modifier = Modifier
                .constrainAs(imageRef) {
                    //通过constrainAs将Image与imageRef绑定,并增加约束
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                .size(100.dp)
                //圆角shape
                .clip(shape = RoundedCornerShape(5)),
            contentScale = ContentScale.Crop)

        Text(
            text = stringResource(id = R.string.test_string),
            modifier = Modifier
                .constrainAs(nameRef) {
                    top.linkTo(imageRef.top)
                    bottom.linkTo(imageRef.bottom)
                    //约束同时添加边距
                    start.linkTo(imageRef.end, 12.dp)
                    end.linkTo(parent.end)
                    //规避文字过长导致挤压布局问题
                    width = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
            maxLines = 1,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = colors.onSurface,
                fontSize = 18.sp
            )
        )

        Text(text = stringResource(id = R.string.test_string), modifier = Modifier
            .constrainAs(descRef) {
                top.linkTo(nameRef.bottom, 5.dp)
                start.linkTo(nameRef.start)
                end.linkTo(parent.end)
                //规避文字过长导致挤压布局问题
                width = Dimension.fillToConstraints
            }
            .fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = colors.onSurface.copy(0.1f),
                fontSize = 13.sp
            )
        )
    }

}

@Preview
@Composable
fun MyConstraintLayoutPreview() {
    MyConstraintLayout()
}
