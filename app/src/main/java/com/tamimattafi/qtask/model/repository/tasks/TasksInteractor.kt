package com.tamimattafi.qtask.model.repository.tasks

import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvp.repositories.database.QueryBuilder
import com.tamimattafi.mvp.repositories.global.BaseRepository
import com.tamimattafi.qtask.model.entities.tasks.Task.Sortables.DATE
import com.tamimattafi.qtask.model.entities.tasks.Task
import io.reactivex.Flowable
import com.tamimattafi.qtask.model.database.DatabaseValues.Tables.TASKS_TABLE
import com.tamimattafi.mvp.repositories.database.QueryBuilder.Direction.DESCENDING
import com.tamimattafi.qtask.model.entities.tasks.Task.Sortables.ID
import com.tamimattafi.mvp.repositories.database.QueryBuilder.Operators.EQUAL_TO
import dagger.Reusable
import javax.inject.Inject

@Reusable
class TasksInteractor @Inject constructor(
    override val api: TasksRepositoryContract.ApiRepository,
    override val database: MvpBaseContract.Database<Task>
): BaseRepository(), TasksRepositoryContract.Interactor {

    private val listQuery = QueryBuilder().selectFrom(TASKS_TABLE).orderBy(DATE, DESCENDING).build()

    override fun refresh(): MvpBaseContract.Callback<Boolean>
        = createCallback { notification ->
            api.getAll().addSuccessListener { apiList ->
                database.getList(listQuery).addSuccessListener { databaseList ->
                    val toDelete = databaseList.subtract(apiList)
                    val toAdd = apiList.subtract(databaseList)

                    toDelete.forEach {
                        database.delete(it)
                    }

                    database.insertAll(ArrayList(toAdd)).addSuccessListener {
                        notification.notifySuccess(true)
                    }.addFailureListener {
                        notification.notifyFailure(it)
                    }.start()

                }.addFailureListener {
                    notification.notifyFailure(it)
                }.start()
            }.addFailureListener {
                notification.notifyFailure(it)
            }
        }

    override fun getItemRx(id: Long): Flowable<Task>
        = database.getRxItem(QueryBuilder().selectFrom(TASKS_TABLE).where(ID, EQUAL_TO, id).build())


    override fun getDataList(): Flowable<List<Task>>
       = database.getRxList(listQuery)

    override fun insertItem(task: Task): MvpBaseContract.Callback<Boolean>
        = createCallback { notification ->
                database.insert(task).addSuccessListener {
                    notification.notifySuccess(true)
                }.addFailureListener {
                    notification.notifyFailure(it)
                }.start()
            }

}