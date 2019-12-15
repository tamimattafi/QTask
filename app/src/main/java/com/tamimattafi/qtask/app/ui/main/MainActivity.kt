package com.tamimattafi.qtask.app.ui.main

import android.os.Bundle
import com.tamimattafi.mvputils.AppUtils.showToast
import com.tamimattafi.navigationmanager.navigation.NavigationActivity
import com.tamimattafi.qtask.R
import javax.inject.Inject
import com.tamimattafi.qtask.app.ui.main.MainContract.*
import com.tamimattafi.qtask.app.ui.main.fragments.auth.LoginFragment
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineFragment

class MainActivity : NavigationActivity(), View {

    @Inject
    lateinit var presenter: Presenter

    override val layoutId: Int = R.layout.activity_main
    override var rootId: Int = R.id.root

    override fun onActivityCreated() {
        theme.applyStyle(R.style.AppTheme, true)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        presenter.onViewCreated()
    }

    override fun attachLoginScreen() {
        requestAttachBaseScreen(LoginFragment())
    }

    override fun attachTimelineScreen() {
        requestAttachBaseScreen(TimelineFragment())
    }

    override fun showMessage(message: String) {
        showToast(message)
    }
}
