package com.tamimattafi.qtask.model.repository.auth

import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvp.MvpBaseContract.Callback
import com.tamimattafi.qtask.model.entities.auth.AccessToken

interface AuthContract {

    interface Repository : MvpBaseContract.Repository {
        fun login(accessToken: AccessToken): Callback<Boolean>
        fun logout(): Callback<Boolean>
        fun isLoggedIn(): Boolean
    }
}