package com.mahdavi.weatherapp.data.model.local.cities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize


@Parcelize
data class CityAutoComplete(
    val country: CityAutoCompleteCountry,
    val key: String,
    val localizedName: String,
    val rank: Int,
    val type: String,
    val version: Int
) : Parcelable

@Parcelize
data class CityAutoCompleteCountry(
    val id: String,
    val localizedName: String
) : Parcelable
