package com.mahdavi.weatherapp.data.repository.user

import com.google.firebase.auth.FirebaseUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUser(): Single<FirebaseUser>
    fun getUserAuthState(): Single<Boolean>
    fun signOut(): Completable
}