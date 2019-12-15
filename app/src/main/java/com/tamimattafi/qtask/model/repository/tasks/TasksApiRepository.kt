package com.tamimattafi.qtask.model.repository.tasks

import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvp.repositories.api.repository.BaseApiRepository
import com.tamimattafi.mvp.repositories.api.repository.QueryBuilder
import com.tamimattafi.qtask.model.client.ClientValues.Paths.Actions.Tasks.CREATE
import com.tamimattafi.qtask.model.client.ClientValues.Paths.Actions.Tasks.EDIT
import com.tamimattafi.qtask.model.client.ClientValues.Paths.Actions.Tasks.GET_ALL
import com.tamimattafi.qtask.model.client.ClientValues.Paths.Actions.Tasks.GET_ONE
import com.tamimattafi.qtask.model.client.ClientValues.Paths.Actions.Tasks.LEAVE
import com.tamimattafi.qtask.model.client.ClientValues.Paths.BASE_LINK
import com.tamimattafi.qtask.model.client.ClientValues.Paths.TASKS
import com.tamimattafi.qtask.model.client.ClientValues.Query.Params.USER
import com.tamimattafi.qtask.model.client.TasksClient
import com.tamimattafi.qtask.model.entities.auth.AccessToken
import com.tamimattafi.qtask.model.entities.tasks.Task
import dagger.Reusable
import javax.inject.Inject

@Reusable
class TasksApiRepository @Inject constructor(private val client: TasksClient,
                                             private val authPreferences: MvpBaseContract.AuthPreferences<AccessToken>) : BaseApiRepository(), TasksRepositoryContract.ApiRepository {


    private val userQuery by lazy {
        QueryBuilder().custom(USER, authPreferences.getToken()?.userId.toString()).build()
    }

    private val getAllUrl by lazy {
        UrlBuilder(BASE_LINK).path("$TASKS.$GET_ALL").query(userQuery).build()
    }

    private val createUrl by lazy {
        UrlBuilder(BASE_LINK).path("$TASKS.$CREATE").query(userQuery).build()
    }

    private val editUrl by lazy {
        UrlBuilder(BASE_LINK).path("$TASKS.$EDIT").query(userQuery).build()
    }

    private val getOneUrl by lazy {
        UrlBuilder(BASE_LINK).path("$TASKS.$GET_ONE").query(userQuery).build()
    }

    private val leaveUrl by lazy {
        UrlBuilder(BASE_LINK).path("$TASKS.$LEAVE").query(userQuery).build()
    }

    override fun getAll(): MvpBaseContract.Callback<ArrayList<Task>>
            = handleResponseBody(client.execute(getAllUrl))


    override fun create(task: Task): MvpBaseContract.Callback<Task>
            = handleResponseBody(client.execute(createUrl))

    override fun edit(task: Task): MvpBaseContract.Callback<Task>
            = handleResponseBody(client.execute(editUrl))


    override fun get(id: Long): MvpBaseContract.Callback<Task>
            = handleResponseBody(client.execute(getOneUrl))


    override fun leave(id: Long): MvpBaseContract.Callback<Boolean>
            = handleResponseBody(client.execute(leaveUrl))
}