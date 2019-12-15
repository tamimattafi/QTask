package com.tamimattafi.qtask.app.ui.main.fragments.timeline

import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvputils.AppUtils.showSnackBar
import com.tamimattafi.navigationmanager.navigation.MvpFragment
import com.tamimattafi.qtask.R
import com.tamimattafi.qtask.app.ui.custom.decorators.ItemOffsetDecorator
import com.tamimattafi.qtask.app.ui.main.fragments.global.tasks.TasksUiContract
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineContract.*
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.add.AddFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.filter.FilterFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.search.SearchFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.view.ViewFragment
import kotlinx.android.synthetic.main.toolbar_timeline.*
import kotlinx.android.synthetic.main.view_fab.*
import kotlinx.android.synthetic.main.view_recycler.*
import javax.inject.Inject

class TimelineFragment : MvpFragment<Presenter>(), View {

    override var fragmentName: String = "fragment-timeline"
    override val layoutId: Int = R.layout.fragment_timeline

    @Inject
    lateinit var adapter: Adapter

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(ItemOffsetDecorator(appActivity.resources.getDimension(R.dimen.item_offset).toInt()))
            adapter = this@TimelineFragment.adapter
        }

        refresher.apply {
            setOnRefreshListener {
                presenter.refresh()
                isRefreshing = false
            }
        }

        add.setOnClickListener {
            navigationManager.requestSlideLeftScreen(AddFragment())
        }

        filter.setOnClickListener {
            navigationManager.requestSlideLeftScreen(FilterFragment())
        }

        search.setOnClickListener {
            navigationManager.requestSlideLeftScreen(SearchFragment())
        }

        presenter.loadData()
    }

    override fun bindHolder(holder: TasksUiContract.Holder) {
        presenter.bindHolder(holder)
    }

    override fun getAdapter(): MvpBaseContract.Adapter
            = adapter

    override fun onHolderAction(holder: TasksUiContract.Holder?, action: Int) {}

    override fun onHolderClick(holder: TasksUiContract.Holder) {
        presenter.onItemClicked(holder.listPosition)
    }

    override fun attachTaskFragment(taskId: Long) {
        navigationManager.requestSlideLeftScreen(
            ViewFragment.newInstance(taskId)
        )
    }

    override fun showMessage(message: String) {
        fragmentView.showSnackBar(message)
    }
}