package com.tamimattafi.qtask.app.di.modules.activity.fragments

import com.tamimattafi.qtask.app.ui.main.fragments.auth.LoginContract.*
import com.tamimattafi.qtask.app.ui.main.fragments.auth.LoginFragment
import com.tamimattafi.qtask.app.ui.main.fragments.auth.LoginPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {

    @Binds
    abstract fun bindView(view: LoginFragment): View

    @Binds
    abstract fun bindPresenter(presenter: LoginPresenter): Presenter

}