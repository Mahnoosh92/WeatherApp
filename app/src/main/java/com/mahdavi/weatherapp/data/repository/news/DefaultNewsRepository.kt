package com.mahdavi.weatherapp.data.repository.news

import androidx.annotation.MainThread
import com.mahdavi.weatherapp.data.dataSource.remote.news.NewsRemoteDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.utils.extensions.getApiError
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

class DefaultNewsRepository @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {
    override fun getNews(page_size: Int): Flowable<ResultWrapper<Exception, List<Article>?>> {
        return newsRemoteDataSource.getNews(page_size)
            .map { response ->
                if (!response.isSuccessful) {
                    ResultWrapper.build {
                        throw Exception(response.getApiError()?.message)
                    }
                } else {
                    ResultWrapper.build {
                        response.body()?.toNews()?.articles
                    }
                }
            }
            .toFlowable()
    }
}