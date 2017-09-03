package com.mibaldipabjimcas.appDeseos.ui.views

import com.mibaldipabjimcas.appDeseos.data.models.Item
import com.mibaldipabjimcas.appDeseos.base.BaseMvpPresenter
import com.mibaldipabjimcas.appDeseos.base.BaseMvpView

object DetailContract {

    interface View : BaseMvpView {
        fun showOrganizations(items: List<Item>)
        fun showProgress()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadRepositories()

    }


}