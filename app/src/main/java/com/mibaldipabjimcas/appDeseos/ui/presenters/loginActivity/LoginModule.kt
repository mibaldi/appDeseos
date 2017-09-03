package com.mibaldipabjimcas.appDeseos.ui.presenters.loginActivity

import com.mibaldipabjimcas.appDeseos.managers.AuthManager
import com.mibaldipabjimcas.appDeseos.ui.activities.LoginActivity
import dagger.Module
import dagger.Provides

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@Module
class LoginModule(val activity: LoginActivity) {

    @Provides
    fun provideAuthManager(): AuthManager {
        val manager = AuthManager(activity)
        return manager
    }

}