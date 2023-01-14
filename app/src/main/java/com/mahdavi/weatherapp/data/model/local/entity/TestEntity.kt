package com.mahdavi.weatherapp.data.model.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class TestEntity(
    @PrimaryKey(autoGenerate = true) val idTable: Int = 0,
    @ColumnInfo(name = "_id") val id: String?
)