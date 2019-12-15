package com.tamimattafi.qtask.app.ui.main.fragments.timeline

import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvp.adapters.RecyclerAdapter
import com.tamimattafi.qtask.app.ui.main.fragments.global.tasks.TasksUiContract
import java.text.ParsePosition

interface TimelineContract {

    interface View : MvpBaseContract.ListenerView<TasksUiContract.Holder> {
        fun attachTaskFragment(taskId: Long)
    }

    interface Presenter : MvpBaseContract.RecyclerPresenter<TasksUiContract.Holder> {
        fun onItemClicked(listPosition: Int)
    }


    abstract class Adapter(view: View) : RecyclerAdapter<TasksUiContract.Holder>(view)
}