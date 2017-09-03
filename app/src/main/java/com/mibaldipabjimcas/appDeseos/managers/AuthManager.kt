package com.mibaldipabjimcas.appDeseos.managers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.mibaldipabjimcas.appDeseos.R
import com.mibaldipabjimcas.appDeseos.domain.callbacks.AuthListener

class AuthManager(activityContext: AppCompatActivity) {

    companion object {
        val RC_SIGN_IN = 9001
    }

    private var mGoogleApiClient: GoogleApiClient? = null
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()

    private var authListener: AuthListener? = null
    private var context: AppCompatActivity? = activityContext

    fun init(listener: AuthListener) {
        authListener = listener

        if (isLogged()) {
            authListener?.onLoginSuccess()
        }

        prepareSignInOptions()
    }


    fun isLogged(): Boolean {
        return mAuth?.currentUser != null
    }

    fun doAuth(data: Intent?) {
        val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
        if (result.isSuccess) {
            val account = result.signInAccount
            account?.let { firebaseAuthWithGoogle(it) }
        } else {
            authListener?.onLoginError()
        }
    }

    fun signIn() {
        val intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        context?.startActivityForResult(intent, AuthManager.RC_SIGN_IN)
    }

    fun signOut() {
        FirebaseAuth.getInstance().signOut()
        authListener = null
    }

    private fun prepareSignInOptions() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context?.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        mGoogleApiClient = context?.let {
            GoogleApiClient.Builder(it)
                    .enableAutoManage(it, {
                        authListener?.onConnectionFailed()
                    })
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build()
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)

        mAuth?.signInWithCredential(credential)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                authListener?.onLoginSuccess()
            } else {
                authListener?.onLoginError()
            }
        }
    }

}
