package com.mahdavi.weatherapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahdavi.weatherapp.data.model.local.entity.ArticleEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getArticles(): Flowable<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateArticles(cities: List<ArticleEntity>): Completable

    @Query("DELETE FROM articles")
    fun clearArticles():Completable
}