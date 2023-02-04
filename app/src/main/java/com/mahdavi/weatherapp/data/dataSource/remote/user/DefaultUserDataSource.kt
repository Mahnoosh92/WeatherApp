package com.mahdavi.weatherapp.data.dataSource.remote.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DefaultUserDataSource @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    UserDataSource {

    override fun getUserAuthState(): Single<Boolean> = Single.fromCallable {
        firebaseAuth.currentUser != null
    }

    override fun getUser(): Single<FirebaseUser> = Single.create { emitter ->
        try {
            firebaseAuth.currentUser?.let {
                emitter.onSuccess(it)
            }
        } catch (exp: Exception) {
            emitter.onError(exp)
        }
    }

    override fun signOut(): Completable = Completable.fromAction {
        Firebase.auth.signOut()
    }
}
