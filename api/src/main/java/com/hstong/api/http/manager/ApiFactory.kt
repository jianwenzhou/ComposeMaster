package com.hstong.api.http.manager

import com.hstong.api.http.controller.PixabayDataController

/**
 * @ClassName ApiFactory
 * @Description TODO
 * @Author zjw
 * @Date 2020/7/12 23:53
 * @Version 1.0
 * 简介：
 */
object ApiFactory {

    private var pixabayData: PixabayDataController? = null

    fun getImageData(): PixabayDataController {
        return pixabayData ?: synchronized(ApiFactory::class) {
            pixabayData ?: RetrofitManager.getInstence().create(PixabayDataController::class.java)
        }
    }


}