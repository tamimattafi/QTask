package com.tamimattafi.qtask.app.ui.main.fragments.timeline.view

import com.tamimattafi.mvp.MvpBaseContract

interface ViewContract {

    interface View : MvpBaseContract.View {
        fun setName(name: String)
        fun setDescription(description: String)
        fun setDate(date: String)
        fun setCanEdit(canEdit: Boolean)
        fun setIsImportant(isImportant: Boolean)
    }

    interface Presenter : MvpBaseContract.Presenter {
        fun loadTask(id: Long)
    }
}