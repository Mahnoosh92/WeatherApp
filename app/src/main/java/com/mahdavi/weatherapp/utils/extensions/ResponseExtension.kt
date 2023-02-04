package com.mahdavi.weatherapp.utils.extensions

import com.mahdavi.weatherapp.data.model.local.MyErrorNews
import com.mahdavi.weatherapp.data.model.local.MyErrorWeather
import com.squareup.moshi.Moshi
import retrofit2.Response

fun Response<*>.getApiErrorWeather(): MyErrorWeather? {
    return try {
        val errorJsonString = this.errorBody()?.string()
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(MyErrorWeather::class.java)
        jsonAdapter.fromJson(errorJsonString ?: "")
    } catch (exception: Exception) {
        exception.printStackTrace()
        null
    }
}
fun Response<*>.getApiErrorNews(): MyErrorNews? {
    return try {
        val errorJsonString = this.errorBody()?.string()
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(MyErrorNews::class.java)
        jsonAdapter.fromJson(errorJsonString ?: "")
    } catch (exception: Exception) {
        exception.printStackTrace()
        null
    }
}
