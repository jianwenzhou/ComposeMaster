package com.jw.demo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jw.http.const.NetConst
import com.jw.http.entity.Hit
import com.jw.http.entity.ImageEntity
import com.jw.http.entity.WeatherEntity
import com.jw.http.manager.ApiFactory
import com.jw.http.manager.CallBackWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @ProjectName ComposeMaster
 * @PackageName com.jw.demo.simple
 * @Author jianwen.zhou
 * @Date 2022/3/10 23:25
 * @Des 首页ViewModel
 */
class MainViewModel : ViewModel() {

    //***********图片列表获取
    private val _imageLiveData = MutableLiveData<MutableList<Hit>>()
    val imageLiveData: LiveData<MutableList<Hit>> = _imageLiveData
    fun getImageList(
        page: Int = 1,
        per_page: Int = 20,
        key: String = "风景",
    ) {
        return ApiFactory.getImageData()
            .getImageList(NetConst.PixabayImageKey, page, per_page, "vertical", "zh", key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CallBackWrapper<ImageEntity>() {
                override fun onSuccess(t: ImageEntity) {
                    _imageLiveData.value = t.hits
                }

                override fun onError(msg: String, code: Int) {
                    super.onError(msg, code)
                }
            })
    }

    //***********天气获取
    private val _weatherLiveData = MutableLiveData<WeatherEntity>()
    val weatherLiveData: LiveData<WeatherEntity> = _weatherLiveData
    fun getSimpleWeather(city: String) {
        ApiFactory.getJuHeData()
            .getSimpleWeather(city, NetConst.SimpleWeatherJuHeKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : CallBackWrapper<WeatherEntity>() {
                    override fun onSuccess(t: WeatherEntity) {
                        if (t.error_code == 0) {
                            _weatherLiveData.value = t
                        } else {
                            onError(t.reason, t.error_code)
                        }
                    }

                    override fun onError(msg: String, code: Int) {
                        super.onError(msg, code)
                    }
                })
    }

}