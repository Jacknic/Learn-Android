package com.jacknic.android.recyclerview.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jacknic.android.recyclerview.TextViewHolder
import com.jacknic.android.recyclerview.TextViewHolder.Companion.createViewHolder

class MyListAdapter(diffCallback: DiffUtil.ItemCallback<String>) : ListAdapter<String, TextViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = createViewHolder(parent)

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.textView.text = getItem(position)
    }
}