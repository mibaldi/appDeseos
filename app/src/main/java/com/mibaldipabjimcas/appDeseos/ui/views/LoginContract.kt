package com.mibaldipabjimcas.appDeseos.ui.views

import com.mibaldipabjimcas.appDeseos.base.BaseMvpPresenter
import com.mibaldipabjimcas.appDeseos.base.BaseMvpView

object LoginContract {

    interface View : BaseMvpView

    interface Presenter : BaseMvpPresenter<View> {
        fun init()
    }


}