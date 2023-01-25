package com.mahdavi.weatherapp.ui.auth.login

import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.GoogleAuthProvider
import com.mahdavi.weatherapp.data.repository.user.authentication.AuthRepository
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val authGoogleRepository: AuthRepository) :
    LoginContract.Presenter {

    override fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account = completedTask.getResult(ApiException::class.java)
//            val firebaseCredential = GoogleAuthProvider.getCredential(account.idToken, null)
//            authGoogleRepository.signInWithCredential(firebaseCredential).subscribe(
//                {
//                },
//                { onError ->
//
//                })
//            val xx = 1
//            // Signed in successfully, show authenticated UI.
//            // TODO
//        } catch (e: ApiException) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Log.w("error", "signInResult:failed code=" + e.statusCode)
//            //TODO
//        }
    }

    override fun detachView(view: LoginContract.View) {

    }

    override fun attachView(view: LoginContract.View) {

    }

    override fun destroy() {

    }
}