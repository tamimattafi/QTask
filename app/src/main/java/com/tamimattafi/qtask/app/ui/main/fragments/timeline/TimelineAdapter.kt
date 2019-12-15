package com.tamimattafi.qtask.app.ui.main.fragments.timeline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.mvp.adapters.holders.empty.UnbindableHolder
import com.tamimattafi.qtask.R
import com.tamimattafi.qtask.app.ui.main.fragments.global.tasks.TaskHolder
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineContract.*
import javax.inject.Inject

class TimelineAdapter @Inject constructor(view: View): Adapter(view) {

    override fun getEmptyHolder(parent: ViewGroup): RecyclerView.ViewHolder
            = UnbindableHolder(parent.inflate(R.layout.holder_empty))

    override fun getItemHolder(parent: ViewGroup): RecyclerView.ViewHolder
            = TaskHolder(parent.inflate(R.layout.holder_task_important))

    override fun getLoadingHolder(parent: ViewGroup): RecyclerView.ViewHolder
            = UnbindableHolder(parent.inflate(R.layout.holder_loading))

    private fun ViewGroup.inflate(layoutId: Int): android.view.View
        = LayoutInflater.from(context).inflate(layoutId, this, false)
}