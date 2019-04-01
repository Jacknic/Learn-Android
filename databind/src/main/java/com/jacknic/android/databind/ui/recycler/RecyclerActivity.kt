package com.jacknic.android.databind.ui.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jacknic.android.databind.R
import com.jacknic.android.databind.data.User
import com.jacknic.android.databind.databinding.ActivityRecyclerBinding

/**
 * @author Jacknic
 * @date 2019/04/01
 */
class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRecyclerBinding>(this, R.layout.activity_recycler)
        val userList = arrayListOf<User>()
        for (i in 0 until 50) {
            userList.add(User("Jacknic $i", 10 + i))
        }
        binding.adapter = UserListAdapter(userList)
    }
}