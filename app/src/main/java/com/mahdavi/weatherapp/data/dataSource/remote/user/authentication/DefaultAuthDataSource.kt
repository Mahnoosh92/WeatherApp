package com.mahdavi.weatherapp.data.dataSource.remote.user.authentication

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class DefaultAuthDataSource @Inject constructor() : AuthDataSource {

    override fun signInWithPhoneCredential(credential: PhoneAuthCredential): Completable =
        Completable.create { emitter -> // change Completable.create since it is a RxJava
            Firebase.auth.signInWithCredential(credential).addOnCompleteListener { task ->
                if (!emitter.isDisposed) {
                    if (task.isSuccessful)
                        emitter.onComplete()
                    else
                        emitter.onError(task.exception!!)
                }
            }
        }


}
