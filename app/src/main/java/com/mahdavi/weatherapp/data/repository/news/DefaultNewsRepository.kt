package com.mahdavi.weatherapp.data.repository.news

import com.mahdavi.weatherapp.data.dataSource.remote.news.NewsRemoteDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.utils.extensions.getApiErrorNews
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class DefaultNewsRepository @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {
    override fun getNews(
        page: Int,
        update: Boolean
    ): Flowable<ResultWrapper<Exception, List<Article>?>> {
        return newsRemoteDataSource.getNews(page = page)
            .map { response ->
                if (response.isSuccessful) {
                    ResultWrapper.build {
                        response.body()?.articles?.map { it.toArticle() }
                    }
                } else {
                    ResultWrapper.build {
                        throw java.lang.Exception(response.getApiErrorNews()?.message)
                    }
                }
            }.toFlowable()
    }
}