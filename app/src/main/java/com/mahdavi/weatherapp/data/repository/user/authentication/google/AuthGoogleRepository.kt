package com.mahdavi.weatherapp.data.repository.user.authentication.google

import com.google.android.gms.auth.api.signin.GoogleSignInOptions

interface AuthGoogleRepository {
    fun getGoogleSignInOptions(): GoogleSignInOptions
}