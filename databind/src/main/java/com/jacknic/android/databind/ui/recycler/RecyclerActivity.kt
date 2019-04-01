package com.jacknic.android.databind.ui.recycler

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jacknic.android.databind.R
import com.jacknic.android.databind.data.User
import com.jacknic.android.databind.databinding.ActivityRecyclerBinding

/**
 * @author Jacknic
 * @date 2019/04/01
 */
class RecyclerActivity : AppCompatActivity(), UserListAdapter.OnItemClickListener {

    private val userList = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRecyclerBinding>(this, R.layout.activity_recycler)
        for (i in 0 until 50) {
            userList.add(User("Jacknic $i", 10 + i))
        }
        val userListAdapter = UserListAdapter(userList)
        userListAdapter.setOnItemClickListener(this)
        binding.adapter = userListAdapter
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(this, "点击$position--${userList[position].name}", Toast.LENGTH_SHORT).show()
    }
}