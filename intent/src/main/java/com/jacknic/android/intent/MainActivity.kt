package com.jacknic.android.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnExplicit = findViewById<View>(R.id.btnExplicit)
        val btnSend = findViewById<View>(R.id.btnSend)
        val btnSend2 = findViewById<View>(R.id.btnSend2)
        btnExplicit.setOnClickListener {
            explicit()
        }
        btnSend.setOnClickListener {
            send()
        }
        btnSend2.setOnClickListener {
            send2()
        }
    }


    /**
     * 显示跳转
     */
    private fun explicit() {
        val intent = Intent(this, OtherActivity::class.java)
        startActivity(intent)
    }

    /**
     * 隐式跳转
     */
    private fun send() {
        val intent = Intent()
        intent.action = "intent_for_other"
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "无法处理Intent", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 隐式跳转2
     */
    private fun send2() {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "无法处理Intent", Toast.LENGTH_SHORT).show()
        }
    }
}
