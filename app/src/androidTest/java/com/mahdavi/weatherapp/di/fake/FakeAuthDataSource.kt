package com.mahdavi.weatherapp.di.fake

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.PhoneAuthCredential
import com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.AuthDataSource
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class FakeAuthDataSource @Inject constructor() : AuthDataSource {

    override fun signInWithPhoneCredential(credential: PhoneAuthCredential): Completable {
        return Completable.complete()
    }

    override fun signInWithCredential(
        account: GoogleSignInAccount,
    ): Completable {
        return Completable.complete()
    }
}