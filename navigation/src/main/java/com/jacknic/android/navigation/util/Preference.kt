package com.jacknic.android.navigation.util

import android.content.Context

const val PREFER = "prefer"
const val KEY_LOGIN_STATUS = "login_status"

class Preference(private val context: Context) {

    /**
     * 是否已经登录
     */
    var logined: Boolean
        get() {
            val preferences = context.getSharedPreferences(PREFER, Context.MODE_PRIVATE)
            return preferences.getBoolean(KEY_LOGIN_STATUS, false)
        }
        set(value) {
            context.getSharedPreferences(PREFER, Context.MODE_PRIVATE)
                    .edit().putBoolean(KEY_LOGIN_STATUS, value)
                    .apply()
        }
}