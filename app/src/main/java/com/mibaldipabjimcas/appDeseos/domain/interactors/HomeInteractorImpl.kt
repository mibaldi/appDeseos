package com.mibaldipabjimcas.appDeseos.domain.interactors

import com.mibaldipabjimcas.appDeseos.data.models.Item
import com.mibaldipabjimcas.appDeseos.data.repositories.Repository

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class HomeInteractorImpl(val repository: Repository) : HomeInteractor {
    override fun getListItems(): List<Item> {
       return repository.getListItems()
    }

    override fun getCurrentItem(): Item {
        return repository.getListItems().first()
    }

}