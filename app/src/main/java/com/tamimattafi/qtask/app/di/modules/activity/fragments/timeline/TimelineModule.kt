package com.tamimattafi.qtask.app.di.modules.activity.fragments.timeline

import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineAdapter
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineContract.*
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelinePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class TimelineModule {

    @Binds
    abstract fun bindView(view: TimelineFragment): View

    @Binds
    abstract fun bindPresenter(presenter: TimelinePresenter): Presenter

    @Binds
    abstract fun bindAdapter(adapter: TimelineAdapter): Adapter

}