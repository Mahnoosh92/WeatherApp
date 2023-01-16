package com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.google

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DefaultAuthGoogleDataSource @Inject constructor() : AuthGoogleDataSource {
    override fun getGoogleSignInOptions() = GoogleSignInOptions
        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()
}
