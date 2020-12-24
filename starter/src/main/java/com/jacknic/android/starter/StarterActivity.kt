package com.jacknic.android.starter

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class StarterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)
        val packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
        val activities = packageInfo.activities.filter { javaClass.name != it.name }
        val activityNameList = activities.map { it.loadLabel(packageManager) }
        val activityList = findViewById<ListView>(R.id.activityList)
        activityList.adapter = ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, activityNameList)
        activityList.setOnItemClickListener { _, _, position, _ ->
            val activityInfo = activities[position]
            val intent = Intent(this, Class.forName(activityInfo.name))
            startActivity(intent)
        }
    }
}