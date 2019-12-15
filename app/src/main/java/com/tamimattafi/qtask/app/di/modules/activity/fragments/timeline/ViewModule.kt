package com.tamimattafi.qtask.app.di.modules.activity.fragments.timeline

import com.tamimattafi.qtask.app.ui.main.fragments.timeline.view.ViewContract.*

import com.tamimattafi.qtask.app.ui.main.fragments.timeline.view.ViewFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.view.ViewPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModule {

    @Binds
    abstract fun bindView(view: ViewFragment): View

    @Binds
    abstract fun bindPresenter(presenter: ViewPresenter): Presenter
}