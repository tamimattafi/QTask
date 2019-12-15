package com.tamimattafi.qtask.app.ui.main.fragments.global.tasks

import com.tamimattafi.mvp.MvpBaseContract

interface TasksUiContract {
    interface Holder : MvpBaseContract.Holder {
        fun setTitle(title: String)
        fun setDescription(description: String)
        fun setFriends(friends: String)
        fun setTime(time: String)
        fun setIsImportant(isImportant: Boolean)
    }
}