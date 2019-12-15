package com.tamimattafi.qtask.app.di.modules.application.global.database

import com.tamimattafi.mvp.repositories.database.BaseDao
import com.tamimattafi.qtask.model.database.dao.TasksDao
import com.tamimattafi.qtask.model.entities.tasks.Task
import dagger.Binds
import dagger.Module


@Module
abstract class DaoModule {

    @Binds
    abstract fun bindTasksDao(dao: TasksDao): BaseDao<Task>
}