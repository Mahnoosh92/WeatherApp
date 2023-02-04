package com.mahdavi.weatherapp.data.dataSource.remote.news

import com.mahdavi.weatherapp.data.api.ApiNewsService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class DefaultNewsRemoteDataSourceTest {

    @Mock
    private lateinit var apiNewsService: ApiNewsService
    private lateinit var defaultNewsRemoteDataSource: DefaultNewsRemoteDataSource

    @Before
    fun setUp() {
        defaultNewsRemoteDataSource = DefaultNewsRemoteDataSource(apiNewsService)
    }
    @After
    fun tearDown() {

    }

    @Test
    fun `test getNews`() {
        // when
        defaultNewsRemoteDataSource.getNews(0)

        // then
        Mockito.verify(apiNewsService).getNews(page = 0)
    }
}