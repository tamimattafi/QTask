package com.tamimattafi.qtask.model.repository.tasks

import com.tamimattafi.mvp.MvpBaseContract.*
import com.tamimattafi.qtask.model.entities.tasks.Task
import io.reactivex.Flowable

interface TasksRepositoryContract {

    interface ApiRepository {
        fun getAll(): Callback<ArrayList<Task>>
        fun create(task: Task): Callback<Task>
        fun edit(task: Task): Callback<Task>
        fun get(id: Long): Callback<Task>
        fun leave(id: Long): Callback<Boolean>
    }

    interface Interactor : RxListRepository<Task> {
        val api: ApiRepository
        val database: Database<Task>
        fun refresh(): Callback<Boolean>
        fun getItemRx(id: Long): Flowable<Task>
        fun insertItem(task: Task): Callback<Boolean>
    }

}