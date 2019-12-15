package com.tamimattafi.qtask.app.ui.main.fragments.timeline.view

import android.util.Log
import com.tamimattafi.mvp.presenters.BasePresenter
import com.tamimattafi.mvputils.DateUtils.longToStringDate
import com.tamimattafi.qtask.app.ui.main.fragments.timeline.view.ViewContract.*
import com.tamimattafi.qtask.model.entities.tasks.Task
import com.tamimattafi.qtask.model.repository.tasks.TasksRepositoryContract.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ViewPresenter @Inject constructor(view: View, repository: Interactor) : BasePresenter<View, Interactor>(view, repository), Presenter {

    private var rxDisposable: Disposable? = null


    override fun loadTask(id: Long) {
        rxDisposable = repository.getItemRx(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { data ->
                view.tryCall {
                    data.apply {
                        setName(name.toString())
                        setDescription(description.toString())
                        setDate(date.longToStringDate("dd MMMM, HH:mm"))
                        setIsImportant(important != 0)
                        setCanEdit(canEdit != 0)
                    }
                }
            }.subscribe()
    }

}
