package com.mahdavi.weatherapp.utils.extensions

import com.mahdavi.weatherapp.data.model.local.MyError
import com.squareup.moshi.Moshi
import retrofit2.Response

fun Response<*>.getApiError(): MyError? {
    return try {
        val errorJsonString = this.errorBody()?.string()
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(MyError::class.java)
        jsonAdapter.fromJson(errorJsonString ?: "")
    } catch (exception: Exception) {
        exception.printStackTrace()
        null
    }
}
