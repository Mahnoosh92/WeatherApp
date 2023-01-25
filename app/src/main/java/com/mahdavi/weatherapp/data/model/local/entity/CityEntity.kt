package com.mahdavi.weatherapp.data.model.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.data.model.local.cities.Details

@Entity(tableName = "cities")
data class CityEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val country: String?,
    @ColumnInfo val englishName: String?,
    @ColumnInfo val latitude: Double?,
    @ColumnInfo val longitude: Double?,
    @ColumnInfo val key: String?,
    @ColumnInfo val localizedName: String?,
    @ColumnInfo val primaryPostalCode: String?,
    @ColumnInfo val rank: Int?,
    @Embedded val details: Details?,
    @ColumnInfo val timeZone: String?,
    @ColumnInfo val type: String?,
    @ColumnInfo val version: Int?
) {
    fun toCity() = City(
        country = country,
        englishName = englishName,
        latitude = latitude,
        longitude = longitude,
        key = key,
        localizedName = localizedName,
        primaryPostalCode = primaryPostalCode,
        rank = rank,
        details = details,
        timeZone = timeZone,
        type = type,
        version = version
        )
}
