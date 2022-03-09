package com.jianwen.composemaster

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
                )
            ),
            MainListData(
                "滚动布局", listOf(
                    Const.LazyRow,
                    Const.LazyColumn,
                )
            ),

            //动画


            //数据流


            //android

        )
    }
}