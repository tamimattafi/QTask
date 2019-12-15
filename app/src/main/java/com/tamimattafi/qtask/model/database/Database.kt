package com.tamimattafi.qtask.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tamimattafi.qtask.model.entities.tasks.Task
import com.tamimattafi.qtask.model.database.DatabaseValues.Information.DATABASE_VERSION
import com.tamimattafi.qtask.model.database.dao.TasksDao
import javax.inject.Singleton

@Singleton
@Database(entities = [Task::class], version = DATABASE_VERSION, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun tasksDao(): TasksDao
}