package com.mibaldipabjimcas.appDeseos.ui.views

import com.mibaldipabjimcas.appDeseos.data.models.Item
import com.mibaldipabjimcas.appDeseos.base.BaseMvpPresenter
import com.mibaldipabjimcas.appDeseos.base.BaseMvpView

object HomeContract {

    interface View : BaseMvpView {
        fun showOrganizations(items: List<Item>)
        fun showProgress()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun init()
        fun loadRepositories()
        fun goToDetail(id: Long)

    }


}