package com.mahdavi.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahdavi.weatherapp.data.model.local.entity.TestEntity

@Database(
    entities = [TestEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

}