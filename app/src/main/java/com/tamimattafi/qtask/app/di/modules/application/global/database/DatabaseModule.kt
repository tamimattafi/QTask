package com.tamimattafi.qtask.app.di.modules.application.global.database

import android.content.Context
import androidx.room.Room
import com.tamimattafi.qtask.model.database.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.tamimattafi.qtask.model.database.DatabaseValues.Information.DATABASE_NAME
import com.tamimattafi.qtask.model.database.dao.TasksDao
import dagger.Reusable

@Module
object DatabaseModule {

    @JvmStatic @Singleton @Provides
    fun provideDatabase(context: Context): Database
            = Room.databaseBuilder(context, Database::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()


    @JvmStatic @Reusable @Provides
    fun provideTasksDao(database: Database): TasksDao = database.tasksDao()

}