package com.mahdavi.weatherapp.data.repository.news

import androidx.annotation.MainThread
import com.mahdavi.weatherapp.data.dataSource.local.news.DefaultNewsLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.local.news.NewsLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.news.NewsRemoteDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.di.IoSchedulers
import com.mahdavi.weatherapp.utils.extensions.getApiError
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject
import kotlin.concurrent.thread

class DefaultNewsRepository @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {
    override fun getNews(
        page: Int,
        update: Boolean
    ): Flowable<ResultWrapper<Exception, List<Article>?>> {
        return if (update) {
            newsRemoteDataSource.getNews(page = page).toFlowable()
                .map { response ->
                    if (response.isSuccessful.not()) {
                        ResultWrapper.build {
                            throw java.lang.Exception(response.getApiError()?.message)
                        }
                    }
                    response.body()?.articles
                }
                .concatMap { list ->
                    list?.let {
                        newsLocalDataSource.clearArticles()
                            .andThen(newsLocalDataSource.updateArticles(list.map {
                                it.toArticle().toArticleEntity()
                            }).andThen(
                                newsLocalDataSource.getArticles().map { list ->
                                    ResultWrapper.build {
                                        list.map {
                                            it.toArticle()
                                        }
                                    }
                                }
                            ))

                    }
                }
        } else {
            newsLocalDataSource.getArticles().map { list ->
                ResultWrapper.build {
                    list.map {
                        it.toArticle()
                    }
                }
            }
        }
    }
}