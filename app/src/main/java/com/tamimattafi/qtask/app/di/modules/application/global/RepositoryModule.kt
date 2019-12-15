package com.tamimattafi.qtask.app.di.modules.application.global

import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvp.repositories.database.DatabaseRepository
import com.tamimattafi.qtask.model.database.dao.TasksDao
import com.tamimattafi.qtask.model.entities.tasks.Task
import com.tamimattafi.qtask.model.repository.auth.AuthContract
import com.tamimattafi.qtask.model.repository.auth.AuthRepository
import com.tamimattafi.qtask.model.repository.tasks.TasksApiRepository
import com.tamimattafi.qtask.model.repository.tasks.TasksInteractor
import com.tamimattafi.qtask.model.repository.tasks.TasksRepositoryContract
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
abstract class RepositoryModule {

    @Reusable @Binds
    abstract fun bindAuthRepository(repository: AuthRepository): AuthContract.Repository

    @Reusable @Binds
    abstract fun bindTaskRepository(repository: TasksApiRepository): TasksRepositoryContract.ApiRepository

    @Reusable @Binds
    abstract fun bindTaskInteractor(interactor: TasksInteractor): TasksRepositoryContract.Interactor

    @Module
    companion object {
        @JvmStatic @Provides @Reusable
        fun provideTaskDatabase(tasksDao: TasksDao): MvpBaseContract.Database<Task> =
            DatabaseRepository<Task>(tasksDao)
    }

}