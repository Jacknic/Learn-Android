package com.jacknic.android.databind.ui.simple

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jacknic.android.databind.R
import com.jacknic.android.databind.data.User
import com.jacknic.android.databind.databinding.ActivitySimpleBinding
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit


/**
 * 数据绑定练习
 *
 * @link https://developer.android.google.cn/topic/libraries/data-binding/
 */
class SimpleActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySimpleBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple)
        binding.user = User("Jacknic", 17)
        // 3 秒后改变用户信息
        ScheduledThreadPoolExecutor(1).schedule({
            runOnUiThread {
                binding.user = User("Jacknic Plus", 19)
            }
        }, 3, TimeUnit.SECONDS)
        val userList = arrayListOf<User>()
        for (i in 0 until 50) {
            userList.add(User("Jacknic $i", 10 + i))
        }
        binding.adapter = UserListAdapter(this, userList)
        binding.itemClickListener = this
    }

    /**
     * 点击事件监听
     */
    override fun onItemClick(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        parent.getItemAtPosition(position)?.let {
            if (it is User) {
                Toast.makeText(this, "点击${it.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
