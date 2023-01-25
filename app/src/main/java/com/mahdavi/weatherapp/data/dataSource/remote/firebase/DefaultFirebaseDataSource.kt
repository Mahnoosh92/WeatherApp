package com.mahdavi.weatherapp.data.dataSource.remote.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class DefaultFirebaseDataSource @Inject constructor() : FirebaseDataSource {

    override fun getAuth(): FirebaseAuth {
        return try {
            Firebase.auth
        } catch (e: Exception) {
            throw e
        }
    }

}