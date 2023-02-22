package com.mahdavi.weatherapp.data.dataSource.remote.city

import com.mahdavi.weatherapp.data.api.ApiService
import com.mahdavi.weatherapp.data.model.local.cities.City
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class DefaultCityDataSourceTest {

    @Mock
    private lateinit var apiService: ApiService
    private lateinit var dataSource: DefaultCityDataSource

    @Before
    fun setUp() {
        dataSource = DefaultCityDataSource(apiService)
    }

    @After
    fun tearDown() {
        /*NO_OP*/
    }

    @Test
    fun test_getTopCities() {
        // When
        dataSource.getTopCities(anyInt())

        // Then
        Mockito.verify(apiService, times(1)).getTopCities(anyInt())
    }
    @Test
    fun `test getAutoCompletedCities`() {
        // When
        dataSource.getAutoCompletedCities(city="")

        // Then
        Mockito.verify(apiService, times(1)).getAutoCompletedCities(city = "")
    }
}