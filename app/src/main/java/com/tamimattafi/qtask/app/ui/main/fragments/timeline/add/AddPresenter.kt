package com.tamimattafi.qtask.app.ui.main.fragments.timeline.add

import android.util.Log
import com.tamimattafi.mvp.presenters.BasePresenter
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.add.AddContract.*
import com.tamimattafi.qtask.model.entities.tasks.Task
import com.tamimattafi.qtask.model.repository.tasks.TasksRepositoryContract.Interactor
import javax.inject.Inject

class AddPresenter @Inject constructor(view: View, repository: Interactor) : BasePresenter<View, Interactor>(view, repository), Presenter {

    override fun saveTask() {
        view.tryCall {
            Task().apply {
                name = getName()
                description = getDescription()
                date = getDate()
                canEdit = getCanEdit().toInt()
                important = getIsImportant().toInt()
                friends = getFriends()
            }.insert()
        }
    }

    private fun Task.insert() {
        view.tryCall {
            repository.insertItem(this@insert).addSuccessListener {
                onSaveSuccess()
            }.addFailureListener {
                onSaveFailure()
            }.start()
        }
    }

    private fun Boolean.toInt(): Int = if (this) 1 else 0

}
