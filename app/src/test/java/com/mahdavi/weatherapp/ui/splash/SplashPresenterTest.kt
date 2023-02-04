package com.mahdavi.weatherapp.ui.splash

import com.mahdavi.weatherapp.data.repository.user.UserRepository
import com.mahdavi.weatherapp.util.RxImmediateSchedulerRule
import io.reactivex.rxjava3.core.Single
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.exceptions.base.MockitoException
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException
import org.mockito.Mockito.`when` as whenever


@RunWith(MockitoJUnitRunner::class)
internal class SplashPresenterTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    private lateinit var view: SplashContract.View

    @Mock
    private lateinit var userRepository: UserRepository

    private lateinit var splashPresenter: SplashPresenter

    @Before
    fun setUp() {
        splashPresenter = SplashPresenter(userRepository, testSchedulerRule.testScheduler, testSchedulerRule.testScheduler)
        splashPresenter.attachView(view)
    }
    @After
    fun teadDown() {
        splashPresenter.detachView(view)
    }

    @Test
    fun `test navigate to dashboard`() {
        // Given
        whenever(userRepository.getUserAuthState()).thenReturn(Single.just(true))

        // When
        splashPresenter.getUserStatus()

        // Then
        verify(view).navigateToDashboard()
    }

    @Test
    fun `test navigate to auth`() {
        // Given
        whenever(userRepository.getUserAuthState()).thenReturn(Single.just(false))
        // When
        splashPresenter.getUserStatus()
        // Then
        verify(view).navigateToAuth()
    }

    @Test
    fun `test show error`() {
        // Given
        val fakeException = MockitoException("")
        whenever(userRepository.getUserAuthState()).thenThrow(fakeException)
        // When
        splashPresenter.getUserStatus()
        //Then
        verify(view).showError("")
    }
}