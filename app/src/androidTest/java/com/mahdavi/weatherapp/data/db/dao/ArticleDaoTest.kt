package com.mahdavi.weatherapp.data.db.dao

import androidx.room.ColumnInfo
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.mahdavi.weatherapp.data.db.AppDataBase
import com.mahdavi.weatherapp.data.model.local.entity.ArticleEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ArticleDaoTest {

    private lateinit var database: AppDataBase
    private lateinit var articleDao: ArticleDao
    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), AppDataBase::class.java
        ).allowMainThreadQueries().build()
        articleDao = database.articleDao()
    }

    @After
    fun closeDatabase() {
        database.close()
        compositeDisposable.clear()
    }

    @Test
    fun testGetArticles() {
        //Given
        val article = ArticleEntity(
            id = 1,
            score = null,
            author = null,
            authors = null,
            clean_url = null,
            country = null,
            excerpt = null,
            is_opinion = null,
            language = null,
            link = null,
            media = null,
            published_date = null,
            published_date_precision = null,
            rank = null,
            rights = null,
            summary = null,
            title = null,
            topic = null,
            twitter_account = null
        )
        articleDao.updateArticles(listOf(article)).subscribe()
        //When
        //Then
        articleDao.getArticles().subscribe({ list ->
            assertThat(list.get(0).id).isEqualTo(0)
        }, {}, {}).also {
            compositeDisposable.add(it)
        }
    }
}