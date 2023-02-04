package com.mahdavi.weatherapp.data.repository.news

import com.google.common.truth.Truth.assertThat
import com.mahdavi.weatherapp.data.dataSource.remote.news.NewsRemoteDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.remote.news.RemoteNews
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import org.mockito.Mockito.`when` as whenever

@RunWith(MockitoJUnitRunner::class)
internal class DefaultNewsRepositoryTest {

    @Mock
    private lateinit var newsRemoteDataSource: NewsRemoteDataSource
    private lateinit var defaultNewsRepository: DefaultNewsRepository
    private val responseSuccessful = Response.success(200, RemoteNews(emptyList()))
    private val responseFailure = Response.error<RemoteNews>(
        400,
        "{\"key\":[\"somestuff\"]}"
            .toResponseBody("application/json".toMediaTypeOrNull())
    )
    private val compositeDisposable = CompositeDisposable()

    @Before
    fun setUp() {
        defaultNewsRepository = DefaultNewsRepository(newsRemoteDataSource)
    }

    @After
    fun tearDown() {
        compositeDisposable.clear()
    }

    @Test
    fun `test getNews is successful`() {
        // Given
        whenever(newsRemoteDataSource.getNews(anyInt())).thenReturn(Single.just(responseSuccessful))

        // When
        compositeDisposable.add(
            defaultNewsRepository.getNews(anyInt(), false)
                .subscribe({
                    if (it is ResultWrapper.Value) {
                        assertThat(it.value!!.size).isEqualTo(0)
                    }
                }, {

                }, {

                })
        )
    }

    @Test
    fun `test getNews is not successful`() {
        // Given
        whenever(newsRemoteDataSource.getNews(anyInt())).thenReturn(Single.just(responseFailure))

        // When
        compositeDisposable.add(
            defaultNewsRepository.getNews(anyInt(), false)
                .subscribe({
                    if (it is ResultWrapper.Error) {
                        assertThat(it.error).isNull()
                    }
                }, {

                }, {

                })
        )
        Mockito.verify(newsRemoteDataSource).getNews(anyInt())
    }
}