package com.jacknic.android.recyclerview.swipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_swipe.*
import java.util.*


class SwipeActivity : AppCompatActivity() {
    val TAG = SwipeActivity::class.java.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.jacknic.android.recyclerview.R.layout.activity_swipe)
        val list = mutableListOf<String>()
        for (i in 1..30) {
            list.add("生成数据 $i")
        }

        val swipeAdapter = SwipeAdapter(list)
        swipeList.adapter = swipeAdapter
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(UP or DOWN or START or END, RIGHT or LEFT) {
            override fun onMove(rv: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                Collections.swap(list, fromPosition, toPosition)
                swipeAdapter.notifyItemMoved(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                list.removeAt(position)
                swipeAdapter.notifyItemRemoved(position)
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(swipeList)
    }
}