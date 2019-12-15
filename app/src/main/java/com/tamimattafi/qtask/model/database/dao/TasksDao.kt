package com.tamimattafi.qtask.model.database.dao

import androidx.room.Dao
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.tamimattafi.mvp.repositories.database.BaseDao
import com.tamimattafi.qtask.model.entities.tasks.Task
import dagger.Reusable
import io.reactivex.Flowable

@Dao @Reusable
interface TasksDao: BaseDao<Task> {

    @RawQuery(observedEntities = [Task::class])
    override fun getRxItem(query: SupportSQLiteQuery): Flowable<Task>

    @RawQuery(observedEntities = [Task::class])
    override fun getRxList(query: SupportSQLiteQuery): Flowable<List<Task>>
    
}