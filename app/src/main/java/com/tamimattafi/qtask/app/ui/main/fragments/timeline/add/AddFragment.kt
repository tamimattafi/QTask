package com.tamimattafi.qtask.app.ui.main.fragments.timeline.add

import android.os.Bundle
import com.tamimattafi.mvputils.AppUtils.showActionSnackBar
import com.tamimattafi.mvputils.AppUtils.showSnackBar
import com.tamimattafi.navigationmanager.navigation.MvpFragment
import com.tamimattafi.qtask.R
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.add.AddContract.*
import kotlinx.android.synthetic.main.fragment_add_task.*
import kotlinx.android.synthetic.main.toolbar_add_task.*
import java.util.*

class AddFragment : MvpFragment<Presenter>(), View {

    override var fragmentName: String = "fragment-add-task"
    override val layoutId: Int =  R.layout.fragment_add_task

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back.setOnClickListener {
            navigationManager.requestBackPress()
        }

        commit.setOnClickListener {
            presenter.saveTask()
        }

        save.setOnClickListener {
            presenter.saveTask()
        }

        cancel.setOnClickListener {
            navigationManager.requestBackPress()
        }

    }

    override fun getFriends(): String
            = friends.text.toString()

    private var date: Date = Date()

    override fun getName(): String
            = name.text.toString()

    override fun getDescription(): String
            = description.text.toString()

    override fun getDate(): Long
            = date.time

    override fun getCanEdit(): Boolean
            = canEdit.isChecked

    override fun getIsImportant(): Boolean
            = important.isChecked

    override fun onSaveSuccess() {
        navigationManager.requestBackPress()
    }

    override fun onSaveFailure() {
        fragmentView.showActionSnackBar(appActivity.resources.getString(R.string.add_task_error), appActivity.resources.getString(R.string.retry)) {
            presenter.saveTask()
        }
    }

    override fun showMessage(message: String) {
        fragmentView.showSnackBar(message)
    }
}