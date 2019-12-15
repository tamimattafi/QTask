package com.tamimattafi.qtask.app.di.modules.activity.fragments.timeline

import com.tamimattafi.qtask.app.ui.main.fragments.timeline.add.AddContract.*
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.add.AddFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.add.AddPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class AddModule {

    @Binds
    abstract fun bindView(view: AddFragment): View

    @Binds
    abstract fun bindPresenter(presenter: AddPresenter): Presenter
}