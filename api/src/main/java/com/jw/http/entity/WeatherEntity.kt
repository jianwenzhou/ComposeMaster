package com.jw.http.entity

/**
 * @ClassName WeatherEntity
 * @Description TODO
 * @Author zjw
 * @Date 2020/9/5 23:18
 * @Version 1.0
 * 简介：
 */

/**
 * WeatherEntity(error_code=0, reason=查询成功!,
 * result=WeatherResult(city=深圳, future=[
 * Future(date=2022-04-18, direct=持续无风向, temperature=17/22℃, weather=阴, wid=Wid(day=02, night=02)),
 * Future(date=2022-04-19, direct=持续无风向, temperature=17/21℃, weather=小雨转多云, wid=Wid(day=07, night=01)),
 * Future(date=2022-04-20, direct=持续无风向, temperature=19/24℃, weather=多云, wid=Wid(day=01, night=01)),
 * Future(date=2022-04-21, direct=持续无风向, temperature=21/26℃, weather=多云, wid=Wid(day=01, night=01)),
 * Future(date=2022-04-22, direct=持续无风向, temperature=23/29℃, weather=多云, wid=Wid(day=01, night=01))],
 * realtime=Realtime(aqi=18, direct=西北风, humidity=83, info=阴, power=2级, temperature=19, wid=02)))
 */

data class WeatherEntity(
    val error_code: Int,
    val reason: String,
    val result: WeatherResult
)

data class WeatherResult(
    val city: String,
    val future: List<Future>,
    val realtime: Realtime
)

data class Future(
    val date: String,
    val direct: String,
    val temperature: String,
    val weather: String,
    val wid: Wid
)

data class Realtime(
    val aqi: String,
    val direct: String,
    val humidity: String,
    val info: String,
    val power: String,
    val temperature: String,
    val wid: String
)

data class Wid(
    val day: String,
    val night: String
)

