package com.tamimattafi.qtask.model.repository.auth

import android.content.SharedPreferences
import com.google.gson.Gson
import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.qtask.model.entities.auth.AccessToken
import com.tamimattafi.qtask.model.repository.auth.AuthPreferences.Keys.IS_LOGGED
import com.tamimattafi.qtask.model.repository.auth.AuthPreferences.Keys.TOKEN
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AuthPreferences @Inject constructor(private val preferences: SharedPreferences) : MvpBaseContract.AuthPreferences<AccessToken> {

    override fun getToken(): AccessToken?
            = preferences.getString(TOKEN, null)?.let {
                Gson().fromJson(it, AccessToken::class.java)
            }

    override fun isLoggedIn(): Boolean
            = preferences.getBoolean(IS_LOGGED, false)


    override fun setLoggedIn(boolean: Boolean)
            = with(preferences.edit()) {
                putBoolean(IS_LOGGED, boolean)
                apply()
            }


    override fun setToken(token: AccessToken?)
            = with(preferences.edit()) {
                putString(TOKEN, Gson().toJson(token))
                apply()
            }

    object Keys {
        const val TOKEN = "auth-access-token-object"
        const val IS_LOGGED = "auth-user-login-boolean"
    }
}