package com.mahdavi.weatherapp.data.repository.user

import com.google.firebase.auth.FirebaseUser
import com.mahdavi.weatherapp.data.dataSource.remote.user.UserDataSource
import io.reactivex.Flowable
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(private val userDataSource: UserDataSource) :
    UserRepository {
    override fun getUser(): Single<FirebaseUser> = userDataSource.getUser()
    override fun getUserAuthState(): Single<Boolean> = userDataSource.getUserAuthState()

    override fun signOut(): Completable = userDataSource.signOut()


}