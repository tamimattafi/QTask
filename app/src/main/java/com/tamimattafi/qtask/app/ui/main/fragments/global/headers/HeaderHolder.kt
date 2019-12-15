package com.tamimattafi.qtask.app.ui.main.fragments.global.headers

import android.view.View
import com.tamimattafi.mvp.adapters.holders.RecyclerHolder
import kotlinx.android.synthetic.main.holder_header_recycler.view.*

class HeaderHolder(itemView: View) : RecyclerHolder(itemView), HeadersContract.TimeHeader {

    override fun setLabel(label: String) {
        itemView.label.text = label
    }

}