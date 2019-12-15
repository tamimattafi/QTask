package com.tamimattafi.qtask.app.di.modules.application.global.database

import com.tamimattafi.mvp.repositories.api.interactor.InteractorBuilder
import com.tamimattafi.qtask.model.client.ClientValues
import com.tamimattafi.qtask.model.client.TasksClient
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
object ClientModule {

    @JvmStatic @Provides @Reusable
    fun provideTaskClient(): TasksClient
        = InteractorBuilder.createInteractor(ClientValues.Paths.BASE_LINK, TasksClient::class.java)
}