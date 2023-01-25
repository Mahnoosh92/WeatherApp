package com.mahdavi.weatherapp.data.dataSource.remote.user.authentication

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.PhoneAuthCredential
import io.reactivex.rxjava3.core.Completable

interface AuthDataSource {

    fun signInWithPhoneCredential(credential: PhoneAuthCredential): Completable

}