package com.tamimattafi.qtask.app.ui.main.fragments.auth

import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.navigationmanager.navigation.NavigationContract
import com.vk.api.sdk.auth.VKAccessToken

interface LoginContract {

    interface View : MvpBaseContract.View, NavigationContract.ActivityResultReceiver {
        fun onLoginSuccess()
        fun onLoginFailure()
    }

    interface Presenter : MvpBaseContract.Presenter {
        fun loginWithVk(token: VKAccessToken)
    }
}