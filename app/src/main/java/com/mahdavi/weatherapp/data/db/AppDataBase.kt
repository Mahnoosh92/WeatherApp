package com.mahdavi.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahdavi.weatherapp.data.db.dao.ArticleDao
import com.mahdavi.weatherapp.data.db.dao.CityDao
import com.mahdavi.weatherapp.data.model.local.entity.ArticleEntity
import com.mahdavi.weatherapp.data.model.local.entity.CityEntity

@Database(
    entities = [CityEntity::class, ArticleEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cityDao(): CityDao
    abstract fun articleDao(): ArticleDao
}