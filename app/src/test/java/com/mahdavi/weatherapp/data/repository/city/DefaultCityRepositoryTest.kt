package com.mahdavi.weatherapp.data.repository.city

import com.google.common.truth.Truth.assertThat
import com.mahdavi.weatherapp.data.dataSource.local.city.CityLocalDataSource
import com.mahdavi.weatherapp.data.dataSource.remote.city.CityDataSource
import com.mahdavi.weatherapp.data.model.local.ResultWrapper
import com.mahdavi.weatherapp.data.model.local.entity.CityEntity
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCity
import com.mahdavi.weatherapp.data.model.remote.cities.RemoteCityAutoComplete
import com.mahdavi.weatherapp.data.model.remote.news.RemoteNews
import io.reactivex.processors.PublishProcessor
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.`when` as whenever
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response


@RunWith(MockitoJUnitRunner::class)
internal class DefaultCityRepositoryTest {
    @Mock
    private lateinit var remoteDataSource: CityDataSource

    @Mock
    private lateinit var localDataSource: CityLocalDataSource

    private lateinit var defaultCityRepository: DefaultCityRepository

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }
    private val responseRemoteSuccessful = Response.success<List<RemoteCity>>(200, emptyList<RemoteCity>())
    private val responseRemoteError = Response.error<List<RemoteCity>>(
        400,
        "{\"key\":[\"somestuff\"]}"
            .toResponseBody("application/json".toMediaTypeOrNull())
    )

    private val responseAutoCompleteRemoteSuccessful = Response.success<List<RemoteCityAutoComplete>>(200, emptyList<RemoteCityAutoComplete>())
    private val responseAutoCompleteRemoteError = Response.error<List<RemoteCityAutoComplete>>(
        400,
        "{\"key\":[\"somestuff\"]}"
            .toResponseBody("application/json".toMediaTypeOrNull())
    )

    @Before
    fun setUp() {
        defaultCityRepository = DefaultCityRepository(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }

    @After
    fun tearDown() {
        compositeDisposable.clear()
    }

    @Test
    fun `getTopCities is successful with update`() {
        //Given
        whenever(remoteDataSource.getTopCities(anyInt())).thenReturn(
            Flowable.just(
                responseRemoteSuccessful
            )
        )
        whenever(localDataSource.updateCities(emptyList())).thenReturn(Completable.complete())
        whenever(localDataSource.getCities()).thenReturn(Flowable.just(emptyList()))
        //When
        defaultCityRepository.getTopCities(anyInt(), true).subscribe({
            if (it is ResultWrapper.Value) {
                assertThat(it.value).isEmpty()
            }
        }, {

        }, {

        }).also {
            compositeDisposable.add(it)
        }
    }

    @Test
    fun `getTopCities is successful without update`() {
        //Given
        //  val publisher = PublishProcessor.create<Void>()
        whenever(localDataSource.getCities()).thenReturn(
            Flowable.just(emptyList())
        )
        //When
        defaultCityRepository.getTopCities(1, false)
            .subscribe({
                if (it is ResultWrapper.Value) {
                    assertThat(it.value).isEmpty()
                }
            }, {

            }, {

            }).also {
                compositeDisposable.add(it)
            }

        // publisher.onComplete()
    }

    @Test
    fun `getTopCities is not successful with update`() {
        //Given
        whenever(remoteDataSource.getTopCities(anyInt())).thenReturn(
            Flowable.just(
                responseRemoteError
            )
        )
        whenever(localDataSource.updateCities(emptyList())).thenReturn(Completable.complete())
        whenever(localDataSource.getCities()).thenReturn(Flowable.just(emptyList()))
        //When
        defaultCityRepository.getTopCities(anyInt(), true).subscribe({
            if (it is ResultWrapper.Error) {
                assertThat(it.error).isNull()
            }
        }, {

        }, {

        }).also {
            compositeDisposable.add(it)
        }
    }

    @Test
    fun `getAutoCompletedCities is successfull`() {
        // Given
        whenever(remoteDataSource.getAutoCompletedCities("")).thenReturn(Flowable.just(responseAutoCompleteRemoteSuccessful))
        // When
        defaultCityRepository.getAutoCompletedCities("").subscribe({
            if(it is ResultWrapper.Value) {
                assertThat(it.value).isEmpty()
            }
        },{

        },{

        }).also {
            compositeDisposable.add(it)
        }
    }
}