package com.mibaldipabjimcas.appDeseos.domain.interactors

import com.mibaldipabjimcas.appDeseos.data.models.Item

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
interface HomeInteractor {


    fun getCurrentItem() : Item
    fun getListItems(): List<Item>

}