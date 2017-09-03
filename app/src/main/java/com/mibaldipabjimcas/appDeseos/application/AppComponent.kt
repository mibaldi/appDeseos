package com.mibaldipabjimcas.appDeseos.application

import com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity.DetailComponent
import com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity.DetailModule
import com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity.HomeComponent
import com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity.HomeModule

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */

@javax.inject.Singleton
@dagger.Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
    fun plus(homeModule: HomeModule): HomeComponent
    fun plus(detailModule: DetailModule): DetailComponent
}