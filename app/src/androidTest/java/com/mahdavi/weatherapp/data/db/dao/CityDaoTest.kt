package com.mahdavi.weatherapp.data.db.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.mahdavi.weatherapp.data.db.AppDataBase
import com.mahdavi.weatherapp.data.model.local.entity.CityEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CityDaoTest {

    private lateinit var database: AppDataBase
    private lateinit var cityDao: CityDao
    private val compositeDisposable = CompositeDisposable()

    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), AppDataBase::class.java
        ).allowMainThreadQueries().build()

        cityDao = database.cityDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }


    @Test
    fun test_updateCities() {
        // Given
        val cityEntity = CityEntity(
            id = 1,
            country = "UK",
            englishName = null,
            latitude = null,
            longitude = null,
            localizedName = null,
            primaryPostalCode = null,
            rank = null,
            key = null,
            details = null,
            timeZone = null,
            version = null,
            type = null
        )

        // When
        cityDao.updateCities(listOf(cityEntity)).subscribe()

        // Then
        cityDao.getCities()
            .subscribe { listCities ->
                assertThat(listCities[0].country).isEqualTo("UK")
            }.also {
                compositeDisposable.add(it)
            }
    }
}