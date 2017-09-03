package com.mibaldipabjimcas.appDeseos.utils

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.mibaldipabjimcas.appDeseos.application.App

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */

fun Context.toast(text:CharSequence, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,text,length).show()
}

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes,this,false )
}
fun ImageView.loadUrl(url: String) {
    Glide.with(context).load(url).into(this)
}

val Activity.app: App get() = application as App
