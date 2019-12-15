package com.tamimattafi.qtask.app.ui.main.fragments.timeline.add

import com.tamimattafi.mvp.MvpBaseContract

interface AddContract {

    interface View : MvpBaseContract.View {
        fun getName(): String
        fun getDescription(): String
        fun getDate(): Long
        fun getCanEdit(): Boolean
        fun getIsImportant(): Boolean
        fun getFriends(): String
        fun onSaveSuccess()
        fun onSaveFailure()
    }

    interface Presenter : MvpBaseContract.Presenter {
        fun saveTask()
    }
}