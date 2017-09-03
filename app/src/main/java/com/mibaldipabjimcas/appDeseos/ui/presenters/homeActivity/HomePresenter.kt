package com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity

import android.util.Log
import com.mibaldipabjimcas.appDeseos.utils.app
import com.mibaldipabjimcas.appDeseos.base.BaseMvpPresenterImpl
import com.mibaldipabjimcas.appDeseos.ui.views.HomeContract
import com.mibaldipabjimcas.appDeseos.domain.interactors.HomeInteractor
import com.mibaldipabjimcas.appDeseos.router.Router
import com.mibaldipabjimcas.appDeseos.ui.activities.MainActivity
import javax.inject.Inject

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class HomePresenter(context: MainActivity): BaseMvpPresenterImpl<HomeContract.View>(), HomeContract.Presenter {

    @Inject
    lateinit var interactor: HomeInteractor


    @Inject
    lateinit var router: Router

    val component by lazy { context.app.component.plus(HomeModule(context)) }

    override fun loadRepositories() {
        val items = interactor.getListItems()
        mView?.showProgress()
        mView?.showOrganizations(items)
    }


    override fun init() {
        component.inject(this)
        val currentItem = interactor.getCurrentItem()
        Log.d("PRESENTER",currentItem.toString())
    }

    override fun goToDetail(id: Long) {
        router.goToDetailActivity(id)
    }
}