package com.jacknic.android.recyclerview.simple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter(private val list: List<String>) : RecyclerView.Adapter<SimpleAdapter.VHolder>() {

    class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        return VHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val content = list[position]
        holder.textView.text = content
    }
}