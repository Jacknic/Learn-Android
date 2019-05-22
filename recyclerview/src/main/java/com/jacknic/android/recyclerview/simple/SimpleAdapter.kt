package com.jacknic.android.recyclerview.simple

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jacknic.android.recyclerview.TextViewHolder
import com.jacknic.android.recyclerview.TextViewHolder.Companion.createViewHolder

class SimpleAdapter(private val list: List<String>) : RecyclerView.Adapter<TextViewHolder>() {

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = createViewHolder(parent)

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val content = list[position]
        holder.textView.text = content
    }
}