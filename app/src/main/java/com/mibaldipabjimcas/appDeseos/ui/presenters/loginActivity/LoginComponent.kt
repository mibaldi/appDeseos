package com.mibaldipabjimcas.appDeseos.ui.presenters.loginActivity

import com.mibaldipabjimcas.appDeseos.ui.activities.LoginActivity

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@javax.inject.Singleton
@dagger.Subcomponent(modules = arrayOf(LoginModule::class))
interface LoginComponent {
    fun inject(activity: LoginActivity)
    fun inject(presenter: LoginPresenter)
}