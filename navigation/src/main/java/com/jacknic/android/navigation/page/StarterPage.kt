package com.jacknic.android.navigation.page


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jacknic.android.navigation.R


/**
 * 起始页
 */
class StarterPage : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.starter_page, container, false)
        return view
    }


}
