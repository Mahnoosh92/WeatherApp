package com.mahdavi.weatherapp.data.repository.user.authentication

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.PhoneAuthCredential
import io.reactivex.rxjava3.core.Completable

interface AuthRepository {
    fun signInWithPhoneCredential(credential: PhoneAuthCredential): Completable
}