package com.mahdavi.weatherapp.data.repository.forecast

import com.google.common.truth.Truth.assertThat
import com.mahdavi.weatherapp.data.dataSource.remote.forecast.RemoteForecastDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.remote.forcast.RemoteDaysForecast
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when` as whenever
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import java.util.concurrent.Flow

@RunWith(MockitoJUnitRunner::class)
internal class DefaultForecastRepositoryTest {

    @Mock
    private lateinit var remoteForecastDataSource: RemoteForecastDataSource
    private lateinit var defaultForecastRepository: DefaultForecastRepository

    private val successfulResponse = Response.success<RemoteDaysForecast>(200, null)
    private val errorResponse = Response.error<RemoteDaysForecast>(
        400,
        "{\"key\":[\"somestuff\"]}"
            .toResponseBody("application/json".toMediaTypeOrNull())
    )
    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    @Before
    fun setUp() {
        defaultForecastRepository = DefaultForecastRepository(remoteForecastDataSource)
    }

    @After
    fun tearDown() {
        compositeDisposable.clear()
    }

    @Test
    fun `test getOneDayForecast is successful`() {
        // Given
        whenever(remoteForecastDataSource.getOneDayForecast("")).thenReturn(
            Flowable.just(
                successfulResponse
            )
        )

        //When
        defaultForecastRepository.getOneDayForecast("").subscribe({
            if (it is ResultWrapper.Value) {
                assertThat(it.value).isNull()
            }
        }, {

        }, {

        }).also {
            compositeDisposable.add(it)
        }
        Mockito.verify(remoteForecastDataSource).getOneDayForecast("")
    }

    @Test
    fun `test getOneDayForecast is not successful`() {
        // Given
        whenever(remoteForecastDataSource.getOneDayForecast("")).thenReturn(
            Flowable.just(
                errorResponse
            )
        )

        //When
        defaultForecastRepository.getOneDayForecast("").subscribe({
            if (it is ResultWrapper.Error) {
                assertThat(it.error).isNull()
            }
        }, {

        }, {

        }).also {
            compositeDisposable.add(it)
        }
        Mockito.verify(remoteForecastDataSource).getOneDayForecast("")
    }

    @Test
    fun `test getFiveDayForecast is successful`() {
        //Given
        whenever(remoteForecastDataSource.getFiveDayForecast("")).thenReturn(Flowable.just(successfulResponse))
        //When
        defaultForecastRepository.getFiveDayForecast("").subscribe({
            if(it is ResultWrapper.Value) {
                assertThat(it.value).isNull()
            }
        },{

        },{

        }).also {
            compositeDisposable.add(it)
        }
    }
}