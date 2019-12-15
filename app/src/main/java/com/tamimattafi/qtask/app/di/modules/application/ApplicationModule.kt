package com.tamimattafi.qtask.app.di.modules.application

import android.content.Context
import com.tamimattafi.qtask.app.ui.Application
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context

}