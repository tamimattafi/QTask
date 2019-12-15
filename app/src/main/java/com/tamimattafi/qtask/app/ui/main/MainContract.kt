package com.tamimattafi.qtask.app.ui.main

import com.tamimattafi.mvp.MvpBaseContract

interface MainContract {


    interface View: MvpBaseContract.View {
        fun attachLoginScreen()
        fun attachTimelineScreen()
    }

    interface Presenter {
        fun onViewCreated()
    }

}