package com.tamimattafi.qtask.app.ui.main.fragments.auth

import com.tamimattafi.mvp.presenters.BasePresenter
import com.tamimattafi.qtask.model.repository.auth.AuthContract.Repository
import com.tamimattafi.qtask.app.ui.main.fragments.auth.LoginContract.*
import com.tamimattafi.qtask.model.entities.auth.AccessToken
import com.vk.api.sdk.auth.VKAccessToken
import dagger.Reusable
import javax.inject.Inject

@Reusable
class LoginPresenter @Inject constructor(view: View, repository: Repository) : BasePresenter<View, Repository>(view, repository), Presenter {

    override fun loginWithVk(token: VKAccessToken) {
        view.tryCall {
            token.takeIf { it.userId != null }?.let {
                repository.login(AccessToken(it)).addCompleteListener {
                    onLoginSuccess()
                }.start()
            } ?: onLoginFailure()
        }
    }
}