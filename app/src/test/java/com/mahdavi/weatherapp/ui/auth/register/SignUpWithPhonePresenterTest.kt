package com.mahdavi.weatherapp.ui.auth.register

import com.google.firebase.auth.PhoneAuthProvider
import com.mahdavi.weatherapp.data.repository.user.authentication.AuthRepository
import com.mahdavi.weatherapp.util.RxImmediateSchedulerRule
import io.reactivex.rxjava3.core.Completable
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.anyOrNull
import org.mockito.Mockito.`when` as whenever

@RunWith(MockitoJUnitRunner::class)
internal class SignUpWithPhonePresenterTest {
    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    private lateinit var authRepository: AuthRepository

    @Mock
    private lateinit var view: SignUpWithPhoneContract.View

    private lateinit var signUpWithPhonePresenter: SignUpWithPhonePresenter

    @Before
    fun signup() {
        signUpWithPhonePresenter = SignUpWithPhonePresenter(
            authRepository,
            testSchedulerRule.testScheduler,
            testSchedulerRule.testScheduler
        )
        signUpWithPhonePresenter.attachView(view)
    }

    @After
    fun tearDown() {
        signUpWithPhonePresenter.detachView(view)
    }

    @Test
    fun `test successful navigate to home`() {
        // Given
        val credential = PhoneAuthProvider.getCredential("storedVerificationId", "code")
        whenever(authRepository.signInWithPhoneCredential(credential)).thenReturn(Completable.complete())
        // When
        signUpWithPhonePresenter.signUp(credential)
        // Then
        verify(view).navigateToHome()
    }
}