package com.mibaldipabjimcas.appDeseos.ui.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mibaldipabjimcas.appDeseos.R
import com.mibaldipabjimcas.appDeseos.base.BaseMvpActivity
import com.mibaldipabjimcas.appDeseos.data.models.Item
import com.mibaldipabjimcas.appDeseos.data.models.getItems
import com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity.DetailPresenter
import com.mibaldipabjimcas.appDeseos.ui.presenters.homeActivity.HomePresenter
import com.mibaldipabjimcas.appDeseos.ui.views.DetailContract
import com.mibaldipabjimcas.appDeseos.utils.loadUrl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: BaseMvpActivity<DetailContract.View,
        DetailPresenter>(),
        DetailContract.View {


    override var mPresenter: DetailPresenter = DetailPresenter(this)
    companion object {

        const val EXTRA_ID = "DetailActivity:Id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getLongExtra(EXTRA_ID, -1)

        val item = getItems().firstOrNull{it.id == id}

        if (item != null)  {
            item_image.loadUrl(item.url)
            item_title.text = item.title
        }
    }

    override fun showOrganizations(items: List<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
