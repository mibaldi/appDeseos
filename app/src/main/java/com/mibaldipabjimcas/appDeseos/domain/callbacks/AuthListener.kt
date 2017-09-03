package com.mibaldipabjimcas.appDeseos.domain.callbacks

/**
 * Created by PabloJC on 3/9/17.
 */
interface AuthListener {
    fun onConnectionFailed()
    fun onLoginSuccess()
    fun onLoginError()
}