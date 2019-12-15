package com.tamimattafi.qtask.app.ui.main.fragments.timeline.search

import android.os.Bundle
import android.view.View
import com.tamimattafi.navigationmanager.navigation.NavigationContract
import com.tamimattafi.qtask.R
import kotlinx.android.synthetic.main.toolbar_search.*

class SearchFragment : NavigationContract.NavigationFragment() {
    override var fragmentName: String = "fragment-search"
    override val layoutId: Int = R.layout.fragment_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back.setOnClickListener {
            navigationManager.requestBackPress()
        }
    }
}