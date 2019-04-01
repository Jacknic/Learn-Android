package com.jacknic.android.databind.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jacknic.android.databind.data.User
import com.jacknic.android.databind.databinding.ItemUserBinding

/**
 * @author Jacknic
 * @date 2019/04/01
 */
class UserListAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    /**
     * 点击事件接口
     */
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    private var mOnItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mOnItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        val binding = DataBindingUtil.findBinding<ItemUserBinding>(holder.itemView)
        binding?.user = user
        mOnItemClickListener?.apply {
            holder.itemView.setOnClickListener {
                onItemClick(it, position)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}