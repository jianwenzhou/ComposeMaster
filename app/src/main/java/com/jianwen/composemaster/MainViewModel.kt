package com.jianwen.composemaster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
            MainListData("Column",1),
            MainListData("Row",2),
            MainListData("Box",3),
            MainListData("Scaffold",4),
            MainListData("ConstraintLayout",5),
            //基本组件
            MainListData("Text",6),
            MainListData("Icon",7),
            MainListData("Image",8),
            MainListData("Button",9),
            MainListData("TextField",10),
            MainListData("Checkbox",11),
            MainListData("Card",12),
            MainListData("Divider",13),
            MainListData("FloatingActionButtons",14),
            MainListData("ProgressIndicator",15),
            MainListData("RadioButton",16),
            //滚动布局
            MainListData("LazyRow",17),
            MainListData("LazyColumn",18),
            //动画


            //数据流

            //android

        )

    }


}