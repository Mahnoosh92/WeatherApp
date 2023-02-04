package com.mahdavi.weatherapp.data.dataSource.remote.forecast

import com.mahdavi.weatherapp.data.api.ApiService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class DefaultRemoteForecastDataSourceTest {

    @Mock
    private lateinit var apiService: ApiService
    private lateinit var defaultRemoteForecastDataSource: DefaultRemoteForecastDataSource

    @Before
    fun setUp() {
        defaultRemoteForecastDataSource = DefaultRemoteForecastDataSource(apiService)
    }
    @After
    fun tearDown() {

    }
    @Test
    fun test_getOneDayForecast() {
        // when
        defaultRemoteForecastDataSource.getOneDayForecast("")

        // then

        Mockito.verify(apiService).getOneDayForcast(key = "")
    }
}