package com.jacknic.android.viewpager.basic

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * @author Jacknic
 * @date 2019/05/10
 */
class BasicAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val pageList = listOf(CardFragment(), CardFragment(), CardFragment())

    override fun getItem(position: Int) = pageList[position]

    override fun getCount() = pageList.size
}