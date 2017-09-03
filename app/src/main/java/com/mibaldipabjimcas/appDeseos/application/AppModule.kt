package com.mibaldipabjimcas.appDeseos.application


import com.mibaldipabjimcas.appDeseos.data.repositories.Repository
import com.mibaldipabjimcas.appDeseos.router.Router


/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */

@dagger.Module class AppModule(val app: App) {


    @dagger.Provides
    @javax.inject.Singleton
    fun provideApp() = app

    @dagger.Provides
    @javax.inject.Singleton
    fun provideRepository(): Repository {
        val repo = Repository()
        return repo
    }

    @dagger.Provides
    @javax.inject.Singleton
    fun provideRouter(): Router {
        val router = Router(app.applicationContext)
        return router
    }

    @dagger.Provides
    @javax.inject.Singleton
    @javax.inject.Named("ApiManager")
    fun provideSomething(): String {
        return "apiManager"
    }

}


