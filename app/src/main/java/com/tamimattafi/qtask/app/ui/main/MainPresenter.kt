package com.tamimattafi.qtask.app.ui.main

import com.tamimattafi.mvp.presenters.BasePresenter
import com.tamimattafi.qtask.app.ui.main.MainContract.*
import com.tamimattafi.qtask.model.repository.auth.AuthContract.Repository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class MainPresenter @Inject constructor(view: View, repository: Repository) : BasePresenter<View, Repository>(view, repository), Presenter {

    override fun onViewCreated() {
        view.tryCall {
            if (repository.isLoggedIn()) {
                attachTimelineScreen()
            } else attachLoginScreen()
        }
    }

}