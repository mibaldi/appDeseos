package com.mibaldipabjimcas.appDeseos.ui.presenters.loginActivity

import android.content.Intent
import com.mibaldipabjimcas.appDeseos.base.BaseMvpPresenterImpl
import com.mibaldipabjimcas.appDeseos.domain.callbacks.AuthListener
import com.mibaldipabjimcas.appDeseos.managers.AuthManager
import com.mibaldipabjimcas.appDeseos.router.Router
import com.mibaldipabjimcas.appDeseos.ui.activities.LoginActivity
import com.mibaldipabjimcas.appDeseos.ui.views.LoginContract
import com.mibaldipabjimcas.appDeseos.utils.app
import javax.inject.Inject

class LoginPresenter(context: LoginActivity) : BaseMvpPresenterImpl<LoginContract.View>(), LoginContract.Presenter, AuthListener {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var authManager: AuthManager

    val component by lazy { context.app.component.plus(LoginModule(context)) }

    private var activityContext = context

    override fun init() {
        component.inject(this)
        authManager.init(this)
    }

    fun onActivityResult(requestCode: Int, data: Intent?) {
        if (requestCode == AuthManager.RC_SIGN_IN) {
            authManager.doAuth(data)
        }
    }

    fun signIn() {
        authManager.signIn()
    }

    override fun onLoginSuccess() {
        router.goToMainActivity()
        router.finishActivity(activityContext)
    }

    override fun onLoginError() {
        mView?.showError("Error en la autenticación")
    }

    override fun onConnectionFailed() {
        mView?.showError("Error en la conexión")
    }

}