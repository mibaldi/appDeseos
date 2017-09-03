package com.mibaldipabjimcas.appDeseos.ui.activities

import android.content.Intent
import android.os.Bundle
import com.mibaldipabjimcas.appDeseos.R
import com.mibaldipabjimcas.appDeseos.base.BaseMvpActivity
import com.mibaldipabjimcas.appDeseos.ui.presenters.loginActivity.LoginModule
import com.mibaldipabjimcas.appDeseos.ui.presenters.loginActivity.LoginPresenter
import com.mibaldipabjimcas.appDeseos.ui.views.LoginContract
import com.mibaldipabjimcas.appDeseos.utils.app
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseMvpActivity<LoginContract.View,
        LoginPresenter>(),
        LoginContract.View {

    override var mPresenter: LoginPresenter = LoginPresenter(this)

    val component by lazy { app.component.plus(LoginModule(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mPresenter.init()
        initView()
    }

    private fun initView() {
        sign_in_button.setOnClickListener { mPresenter.signIn() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mPresenter.onActivityResult(requestCode, data)
    }

}
