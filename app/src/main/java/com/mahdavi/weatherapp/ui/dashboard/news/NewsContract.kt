package com.mahdavi.weatherapp.ui.dashboard.news

import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.data.model.remote.news.HeadlineArticle
import com.mahdavi.weatherapp.ui.base.BasePresenter
import com.mahdavi.weatherapp.ui.base.BaseView
import io.reactivex.rxjava3.core.Flowable
import java.lang.Exception

interface NewsContract {
    interface View : BaseView {
        fun showLoader()
        fun hideLoader()

        fun showError(message: String)

        fun populateNews(news: List<Article?>)
    }

    interface Presenter : BasePresenter<View> {
        fun getNews(page_size: Int)
    }
}