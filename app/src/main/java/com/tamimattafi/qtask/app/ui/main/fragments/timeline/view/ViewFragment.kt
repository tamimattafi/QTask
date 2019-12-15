package com.tamimattafi.qtask.app.ui.main.fragments.timeline.view

import android.os.Bundle
import android.view.View
import com.tamimattafi.mvputils.AppUtils.showSnackBar
import com.tamimattafi.navigationmanager.navigation.MvpFragment
import com.tamimattafi.qtask.R
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.view.ViewContract.*
import kotlinx.android.synthetic.main.fragment_view_task.*
import kotlinx.android.synthetic.main.toolbar_view_task.*

class ViewFragment : MvpFragment<Presenter>(), ViewContract.View {

    override var fragmentName: String = "fragment-view-task"
    override val layoutId: Int = R.layout.fragment_view_task

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back.setOnClickListener {
            navigationManager.requestBackPress()
        }

        arguments?.let {
            presenter.loadTask(it.getLong(TASK_ID))
        }
    }

    override fun setName(name: String) {
        this.name.setText(name)
    }

    override fun setDescription(description: String) {
        this.description.setText(description)
    }

    override fun setDate(date: String) {
        this.date.setText(date)
    }

    override fun setCanEdit(canEdit: Boolean) {
        this.canEdit.isChecked = canEdit
    }

    override fun setIsImportant(isImportant: Boolean) {
        this.important.isChecked = isImportant
    }

    override fun showMessage(message: String) {
        fragmentView.showSnackBar(message)
    }

    companion object {
        fun newInstance(taskId: Long): ViewFragment = ViewFragment().apply {
            arguments = Bundle().apply {
                putLong(TASK_ID, taskId)
            }
        }

        const val TASK_ID = "taskId"
    }
}