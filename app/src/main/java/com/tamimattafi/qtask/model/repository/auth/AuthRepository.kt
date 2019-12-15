package com.tamimattafi.qtask.model.repository.auth

import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvp.MvpBaseContract.*
import com.tamimattafi.mvp.repositories.api.repository.BaseApiRepository
import com.tamimattafi.qtask.model.entities.auth.AccessToken
import com.tamimattafi.qtask.model.repository.auth.AuthContract.Repository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AuthRepository @Inject constructor(private val preferences: MvpBaseContract.AuthPreferences<AccessToken>) : BaseApiRepository(), Repository {

    override fun isLoggedIn(): Boolean
        = preferences.isLoggedIn()

    override fun login(accessToken: AccessToken): Callback<Boolean>
            = createCallback { notification ->
        
                preferences.apply {
                    setToken(accessToken)
                    setLoggedIn(true)
                }

                notification.notifyComplete()
            }

    override fun logout(): Callback<Boolean>
            = createCallback { notification ->
                preferences.apply {
                    setLoggedIn(false)
                    setToken(null)
                }

                notification.notifyComplete()
            }
}