package com.mahdavi.weatherapp.data.dataSource.local.news

import com.mahdavi.weatherapp.data.db.dao.ArticleDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.times

@RunWith(MockitoJUnitRunner::class)
internal class DefaultNewsLocalDataSourceTest {

    @Mock
    private lateinit var articleDao: ArticleDao
    private lateinit var defaultNewsLocalDataSource: DefaultNewsLocalDataSource

    @Before
    fun setup() {
        defaultNewsLocalDataSource = DefaultNewsLocalDataSource((articleDao))
    }
    @After
    fun tearDown() {
        /*NO_OP*/
    }
    @Test
    fun `test getArticles`() {
        defaultNewsLocalDataSource.getArticles()

        Mockito.verify(articleDao, times(1)).getArticles()
    }
    @Test
    fun `test updateArticles`() {
        defaultNewsLocalDataSource.updateArticles(emptyList())

        Mockito.verify(articleDao, times(1)).updateArticles(emptyList())
    }
    @Test
    fun `test clearArticles`() {
        defaultNewsLocalDataSource.clearArticles()

        Mockito.verify(articleDao, times(1)).clearArticles()
    }
}