package com.mahdavi.weatherapp.data.repository.user.authentication

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.PhoneAuthCredential
import com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.AuthDataSource
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class DefaultAuthRepository @Inject constructor(private var dataSource: AuthDataSource) :
    AuthRepository {
    override fun signInWithPhoneCredential(credential: PhoneAuthCredential) = dataSource.signInWithPhoneCredential(credential)
    override fun signInWithCredential(account: GoogleSignInAccount): Completable = dataSource.signInWithCredential(account)
}