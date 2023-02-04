package com.mahdavi.weatherapp.data.dataSource.remote.user

import com.google.firebase.auth.FirebaseAuth
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class DefaultUserDataSourceTest {

    @Mock
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var defaultUserDataSource: DefaultUserDataSource

    @Before
    fun setUp() {
        defaultUserDataSource = DefaultUserDataSource(firebaseAuth)
    }
    @After
    fun tearDown() {

    }
    @Test
    fun `test getUserAuthState`() {
        // when
        defaultUserDataSource.getUserAuthState().subscribe()

        //then
        Mockito.verify(firebaseAuth, times(1)).currentUser
    }
}