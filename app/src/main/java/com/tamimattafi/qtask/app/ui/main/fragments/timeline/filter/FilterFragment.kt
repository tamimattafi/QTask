package com.tamimattafi.qtask.app.ui.main.fragments.timeline.filter

import android.os.Bundle
import android.view.View
import com.tamimattafi.navigationmanager.navigation.NavigationContract
import com.tamimattafi.qtask.R
import kotlinx.android.synthetic.main.toolbar_search.*

class FilterFragment : NavigationContract.NavigationFragment() {
    override var fragmentName: String = "fragment-filter"
    override val layoutId: Int = R.layout.fragment_filter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back.setOnClickListener {
            navigationManager.requestBackPress()
        }
    }
}