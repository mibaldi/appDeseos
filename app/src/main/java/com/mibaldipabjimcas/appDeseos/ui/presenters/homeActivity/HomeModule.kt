package com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity

import com.mibaldipabjimcas.appDeseos.data.repositories.Repository
import com.mibaldipabjimcas.appDeseos.domain.interactors.HomeInteractor
import com.mibaldipabjimcas.appDeseos.domain.interactors.HomeInteractorImpl
import com.mibaldipabjimcas.appDeseos.ui.activities.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
@Module
class HomeModule(val activity: MainActivity) {

    @Provides
    fun provideRepository(repository: Repository): HomeInteractor {
        val interactor = HomeInteractorImpl(repository)
        return interactor
    }
}