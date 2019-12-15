package com.tamimattafi.qtask.app.ui.main.fragments.auth

import android.content.Intent
import android.os.Bundle
import com.tamimattafi.mvputils.AppUtils.showToast
import com.tamimattafi.navigationmanager.navigation.MvpFragment
import com.tamimattafi.qtask.R
import com.tamimattafi.qtask.app.ui.main.fragments.auth.LoginContract.*
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.TimelineFragment
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : MvpFragment<Presenter>(), View {

    override var fragmentName: String = "fragment-login"
    override val layoutId: Int = R.layout.fragment_login

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login.setOnClickListener {
            navigationManager.setActivityReceiver(this)
            VK.login(appActivity, arrayListOf(VKScope.FRIENDS))
        }
    }

    override fun onLoginSuccess() {
        navigationManager.requestAttachBaseScreen(TimelineFragment())
    }

    override fun showMessage(message: String) {
        appActivity.showToast(message)
    }

    override fun onLoginFailure() {
        showMessage(appActivity.resources.getString(R.string.login_error))
    }

    override fun onReceiveActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object: VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                presenter.loginWithVk(token)
            }

            override fun onLoginFailed(errorCode: Int) {
                onLoginFailure()
            }
        }

        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}