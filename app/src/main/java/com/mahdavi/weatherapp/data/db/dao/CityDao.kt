package com.mahdavi.weatherapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahdavi.weatherapp.data.model.local.entity.CityEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Query("SELECT * FROM cities")
    fun getCities(): Flowable<List<CityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateCities(cities: List<CityEntity>): Completable
}