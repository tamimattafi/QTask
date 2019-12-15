package com.tamimattafi.qtask.app.di.modules.application.global

import android.content.Context
import android.content.SharedPreferences
import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.qtask.app.common.PreferencesValues.PREFERENCES_NAME
import com.tamimattafi.qtask.model.entities.auth.AccessToken
import com.tamimattafi.qtask.model.repository.auth.AuthPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
abstract class PreferencesModule {

    @Reusable @Binds
    abstract fun bindAuthPreferences(authPreferences: AuthPreferences): MvpBaseContract.AuthPreferences<AccessToken>

    @Module
    companion object {
        @JvmStatic @Provides @Reusable
        fun provideAppPreferences(context: Context): SharedPreferences
            = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

}