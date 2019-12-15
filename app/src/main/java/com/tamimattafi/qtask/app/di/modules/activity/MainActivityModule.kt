package com.tamimattafi.qtask.app.di.modules.activity

import android.app.Activity
import com.tamimattafi.navigationmanager.navigation.NavigationContract
import com.tamimattafi.qtask.app.ui.main.MainActivity
import com.tamimattafi.qtask.app.ui.main.MainContract.*
import com.tamimattafi.qtask.app.ui.main.MainPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun bindView(view: MainActivity): View

    @Binds
    abstract fun bindPresenter(presenter: MainPresenter): Presenter

    @Binds
    abstract fun bindNavigationManager(mainActivity: MainActivity): NavigationContract.NavigationManager

    @Binds
    abstract fun bindActivity(mainActivity: MainActivity): Activity
}