package com.jw.http.manager

import com.jw.http.controller.AliRecipeController
import com.jw.http.controller.JuHeDataController
import com.jw.http.controller.PixabayDataController

/**
 * @ClassName ApiFactory
 * @Description TODO
 * @Author zjw
 * @Date 2020/7/12 23:53
 * @Version 1.0
 * 简介：
 */
object ApiFactory {

    private var juHeData: JuHeDataController? = null

    fun getJuHeData(): JuHeDataController {
        return juHeData ?: synchronized(ApiFactory::class) {
            juHeData ?: RetrofitManager.getInstence().create(JuHeDataController::class.java)
        }
    }

    private var pixabayData: PixabayDataController? = null

    fun getImageData(): PixabayDataController {
        return pixabayData ?: synchronized(ApiFactory::class) {
            pixabayData ?: RetrofitManager.getInstence().create(PixabayDataController::class.java)
        }
    }


    private var aliRecipeData: AliRecipeController? = null

    fun getRecipeData(): AliRecipeController {
        return aliRecipeData ?: synchronized(ApiFactory::class) {
            aliRecipeData ?: RetrofitManager.getInstence().create(AliRecipeController::class.java)
        }
    }


}