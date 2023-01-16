package com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.google

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface AuthGoogleDataSource {

    fun getGoogleSignInOptions(): GoogleSignInOptions

}