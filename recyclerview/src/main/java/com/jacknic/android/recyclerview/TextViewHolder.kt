package com.jacknic.android.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textView = itemView as TextView

    companion object {
        /**
         * 创建viewHolder对象
         */
        fun createViewHolder(parent: ViewGroup): TextViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            return TextViewHolder(view)
        }
    }
}