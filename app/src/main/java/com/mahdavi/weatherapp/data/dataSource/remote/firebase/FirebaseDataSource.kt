package com.mahdavi.weatherapp.data.dataSource.remote.firebase

import com.google.firebase.auth.FirebaseAuth

interface FirebaseDataSource {
    fun getAuth(): FirebaseAuth
}