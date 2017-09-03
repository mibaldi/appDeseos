package com.mibaldipabjimcas.appDeseos.base

interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(view: V)

    fun detachView()
}