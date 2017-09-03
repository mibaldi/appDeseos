package com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity

import com.mibaldipabjimcas.appDeseos.utils.app
import com.mibaldipabjimcas.appDeseos.base.BaseMvpPresenterImpl
import com.mibaldipabjimcas.appDeseos.ui.views.DetailContract
import com.mibaldipabjimcas.appDeseos.ui.activities.DetailActivity

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class DetailPresenter(context: DetailActivity): BaseMvpPresenterImpl<DetailContract.View>(), DetailContract.Presenter {

    val component by lazy { context.app.component.plus(DetailModule(context)) }

    override fun loadRepositories() {

    }


    fun init() {

    }
}