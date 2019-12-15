package com.tamimattafi.qtask.app.ui.main.fragments.global.tasks

import android.graphics.Color
import android.view.View
import com.tamimattafi.mvp.adapters.holders.RecyclerHolder
import com.tamimattafi.mvputils.AppUtils
import com.tamimattafi.qtask.R
import kotlinx.android.synthetic.main.holder_task_important.view.*

class TaskHolder(itemView: View) : RecyclerHolder(itemView), TasksUiContract.Holder {

    override fun setTitle(title: String) {
        itemView.title.text = title
    }

    override fun setDescription(description: String) {
        itemView.description?.text = description
    }

    override fun setFriends(friends: String) {
        itemView.friends.text = friends
    }

    override fun setTime(time: String) {
        itemView.time.text = time
    }

    override fun setIsImportant(isImportant: Boolean) {
        with(itemView) {
            if (!isImportant) {
                description.visibility = View.GONE
                Color.LTGRAY.applyToView()
            } else {
                description.visibility = View.VISIBLE
                AppUtils.getColor(context, R.color.colorPrimary).applyToView()
            }
        }
    }

    private fun Int.applyToView() {
        with(itemView) {
            Color.LTGRAY.let {
                title.setTextColor(this@applyToView)
                friends.setTextColor(this@applyToView)
                time.setTextColor(this@applyToView)
                friendsLogo.setColorFilter(this@applyToView)
            }
        }
    }


}