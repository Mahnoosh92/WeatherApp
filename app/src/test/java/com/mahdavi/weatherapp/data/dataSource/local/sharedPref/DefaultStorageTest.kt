package com.mahdavi.weatherapp.data.dataSource.local.sharedPref

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner

@RunWith(AndroidJUnit4::class)
internal class DefaultStorageTest {

    private lateinit var defaultStorage: DefaultStorage
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val key = "KEY"
    private val value = "test"
    private val compositeDisposable = CompositeDisposable()

    @Before
    fun setup() {
        defaultStorage = DefaultStorage(context)
    }

    @Test
    fun `successful saving string into sharedPref`() {
        // Given

        // When
        defaultStorage.setString(key, value)

        // Then
        defaultStorage.getString(key)
            .asObservable()
            .subscribe {
                assertThat(it).isEqualTo(value)
            }.also {
                compositeDisposable.add(it)
            }
    }

    @Test
    fun `unsuccessful into saving string into sharedPref`() {
        // Given

        // When
        defaultStorage.setString(key, value)

        // Then
        defaultStorage.getString("newKey")
            .asObservable()
            .subscribe {
                assertThat(it).isNotEqualTo(value)
            }.also {
                compositeDisposable.add(it)
            }
    }
}