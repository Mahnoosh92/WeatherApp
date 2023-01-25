package com.mahdavi.weatherapp.data.dataSource.remote.user

import com.google.firebase.auth.FirebaseUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface UserDataSource {
    fun getUserAuthState(): Single<Boolean>
    fun getUser(): Single<FirebaseUser>
    fun signOut(): Completable
}