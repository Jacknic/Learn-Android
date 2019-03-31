package com.jacknic.android.databind

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jacknic.android.databind.data.User
import com.jacknic.android.databind.databinding.ActivitySimpleBinding
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit


/**
 * 数据绑定练习
 *
 * @link https://developer.android.google.cn/topic/libraries/data-binding/
 */
class SimpleActivity : AppCompatActivity() {

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
        for (i in 0 until 10) {
            userList.add(User("Jacknic $i", 10 + i))
        }
        binding.adapter = UserListAdapter(this, userList)
    }
}
