package com.tamimattafi.qtask.app.di.modules.activity.global

import com.tamimattafi.qtask.app.di.modules.activity.MainActivityModule
import com.tamimattafi.qtask.app.di.modules.activity.fragments.global.MainFragmentsModule
import com.tamimattafi.qtask.app.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainFragmentsModule::class])
    abstract fun mainActivity(): MainActivity

}