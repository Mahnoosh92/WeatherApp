package com.mahdavi.weatherapp.data.dataSource.remote.user.authentication


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class DefaultAuthDataSource @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthDataSource {

    override fun signInWithPhoneCredential(credential: PhoneAuthCredential): Completable =
        Completable.create { emitter -> // change Completable.create since it is a RxJava
            firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (!emitter.isDisposed) {
                        if (task.isSuccessful)
                            emitter.onComplete()
                        else
                            emitter.onError(task.exception!!)
                    }
                }
        }
}