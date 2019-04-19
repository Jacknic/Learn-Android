package com.jacknic.android.databind.ui.simple

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.jacknic.android.databind.data.User
import com.jacknic.android.databind.databinding.ItemUserBinding

/**
 * @author Jacknic
 * @date 2019/03/30
 */
class UserListAdapter(context: Context, userList: List<User>) : ArrayAdapter<User>(context, 0, userList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemUserBinding
        binding = if (convertView == null) {
            val inflater = LayoutInflater.from(parent.context)
            ItemUserBinding.inflate(inflater, parent, false)
        } else {
            DataBindingUtil.getBinding(convertView)!!
        }
        binding.user = getItem(position)
        return binding.root
    }
}
