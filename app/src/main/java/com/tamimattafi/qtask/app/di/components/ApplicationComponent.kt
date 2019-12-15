package com.tamimattafi.qtask.app.di.components

import com.tamimattafi.qtask.app.di.modules.activity.global.ActivityModule
import com.tamimattafi.qtask.app.di.modules.application.ApplicationModule
import com.tamimattafi.qtask.app.di.modules.application.global.PreferencesModule
import com.tamimattafi.qtask.app.di.modules.application.global.RepositoryModule
import com.tamimattafi.qtask.app.di.modules.application.global.database.ClientModule
import com.tamimattafi.qtask.app.di.modules.application.global.database.DaoModule
import com.tamimattafi.qtask.app.di.modules.application.global.database.DatabaseModule
import com.tamimattafi.qtask.app.ui.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ActivityModule::class,
    ApplicationModule::class,
    PreferencesModule::class,
    RepositoryModule::class,
    DatabaseModule::class,
    DaoModule::class,
    ClientModule::class])
interface ApplicationComponent : AndroidInjector<Application> {
    override fun inject(instance: Application?)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent

    }
}