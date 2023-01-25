package com.mahdavi.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahdavi.weatherapp.data.db.dao.CityDao
import com.mahdavi.weatherapp.data.model.local.entity.CityEntity

@Database(
    entities = [CityEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}