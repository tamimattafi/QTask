package com.tamimattafi.qtask.app.ui.main.fragments.timeline

import com.tamimattafi.mvp.presenters.recycler.RxRecyclerPresenter
import com.tamimattafi.mvputils.DateUtils.longToStringDate
import com.tamimattafi.qtask.app.ui.main.fragments.global.tasks.TasksUiContract
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineContract.*
import com.tamimattafi.qtask.model.entities.tasks.Task
import com.tamimattafi.qtask.model.repository.tasks.TasksRepositoryContract
import dagger.Reusable
import javax.inject.Inject

@Reusable
class TimelinePresenter @Inject constructor(view: View, repository: TasksRepositoryContract.Interactor)
    : RxRecyclerPresenter<Task, TasksUiContract.Holder, View, TasksRepositoryContract.Interactor>(view, repository), Presenter {

    override fun bindHolder(holder: TasksUiContract.Holder) {
        with(holder) {
            data[listPosition].apply {
                setTitle(name.toString())
                setDescription(description.toString())
                setTime(date.longToStringDate("dd MMMM, HH:mm"))
                setIsImportant(important != 0)
                setFriends(friends.split(",").size.toString())
            }
        }
    }

    override fun onItemClicked(listPosition: Int) {
        view.tryCall {
            attachTaskFragment(data[listPosition].id!!)
        }
    }

}