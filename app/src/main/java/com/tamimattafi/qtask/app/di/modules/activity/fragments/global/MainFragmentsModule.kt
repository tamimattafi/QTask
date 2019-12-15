package com.tamimattafi.qtask.app.di.modules.activity.fragments.global

import com.tamimattafi.qtask.app.di.modules.activity.fragments.LoginModule
import com.tamimattafi.qtask.app.di.modules.activity.fragments.timeline.AddModule
import com.tamimattafi.qtask.app.di.modules.activity.fragments.timeline.TimelineModule
import com.tamimattafi.qtask.app.di.modules.activity.fragments.timeline.ViewModule
import com.tamimattafi.qtask.app.ui.main.fragments.auth.LoginFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.add.AddFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.filter.FilterFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.search.SearchFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.view.ViewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsModule {

    @ContributesAndroidInjector(modules = [TimelineModule::class])
    abstract fun timelineFragment(): TimelineFragment

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun loginFragment(): LoginFragment

    @ContributesAndroidInjector(modules = [AddModule::class])
    abstract fun addFragment(): AddFragment

    @ContributesAndroidInjector
    abstract fun filterFragment(): FilterFragment

    @ContributesAndroidInjector
    abstract fun searchFragment(): SearchFragment

    @ContributesAndroidInjector(modules = [ViewModule::class])
    abstract fun viewFragment(): ViewFragment
}