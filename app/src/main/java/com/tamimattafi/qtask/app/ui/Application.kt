package com.tamimattafi.qtask.app.ui

import com.tamimattafi.qtask.app.di.components.DaggerApplicationComponent
import com.vk.api.sdk.VK
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class Application : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
       = DaggerApplicationComponent.builder().application(this).build()


}