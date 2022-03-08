package com.jianwen.composemaster

import androidx.lifecycle.LiveData
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

    private val _data = MutableLiveData<List<MainListData>>(listOf())

    var data: LiveData<List<MainListData>> = _data



    init {
        _data.value = listOf(
            //布局
            MainListData(Const.Column),
            MainListData(Const.Row),
            MainListData(Const.Box),
            MainListData(Const.Scaffold),
            MainListData(Const.ConstraintLayout),
            //基本组件
            MainListData(Const.Text),
            MainListData(Const.Icon),
            MainListData(Const.Image),
            MainListData(Const.Button),
            MainListData(Const.TextField),
            MainListData(Const.Checkbox),
            MainListData(Const.Card),
            MainListData(Const.Divider),
            MainListData(Const.FloatingActionButtons),
            MainListData(Const.ProgressIndicator),
            MainListData(Const.RadioButton),
            //滚动布局
            MainListData(Const.LazyRow),
            MainListData(Const.LazyColumn),
            //动画


            //数据流

            //android

        )

    }


}