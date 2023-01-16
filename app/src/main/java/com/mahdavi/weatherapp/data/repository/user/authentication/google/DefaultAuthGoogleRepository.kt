package com.mahdavi.weatherapp.data.repository.user.authentication.google

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.mahdavi.weatherapp.data.dataSource.remote.user.authentication.google.AuthGoogleDataSource
import javax.inject.Inject

class DefaultAuthGoogleRepository @Inject constructor(private var dataSource: AuthGoogleDataSource) :
    AuthGoogleRepository {
    override fun getGoogleSignInOptions() = dataSource.getGoogleSignInOptions()

}