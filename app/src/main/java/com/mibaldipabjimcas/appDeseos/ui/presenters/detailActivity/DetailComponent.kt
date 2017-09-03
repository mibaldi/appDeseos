package com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity

import com.mibaldipabjimcas.appDeseos.ui.activities.DetailActivity

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@javax.inject.Singleton
@dagger.Subcomponent(modules = arrayOf(DetailModule::class))
interface DetailComponent {
    fun inject(activity: DetailActivity)
    fun inject(presenter: DetailPresenter)
}