package com.mahdavi.weatherapp.data.dataSource.local.city

import com.mahdavi.weatherapp.data.db.dao.CityDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class DefaultCityLocalDataSourceTest {

    @Mock
    private lateinit var cityDao: CityDao
    private lateinit var defaultCityLocalDataSource: DefaultCityLocalDataSource

    @Before
    fun setUp() {
        defaultCityLocalDataSource = DefaultCityLocalDataSource(cityDao)
    }
    @After
    fun tearDown() {
        /*NO_OP*/
    }

    @Test
    fun `test getCities`() {
        defaultCityLocalDataSource.getCities()
        Mockito.verify(cityDao, times(1)).getCities()
    }

    @Test
    fun `test updateCities`() {
        defaultCityLocalDataSource.updateCities(cities = emptyList())
        Mockito.verify(cityDao, times(1)).updateCities(emptyList())
    }
}