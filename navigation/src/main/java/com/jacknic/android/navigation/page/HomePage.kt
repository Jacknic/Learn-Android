package com.jacknic.android.navigation.page


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.jacknic.android.navigation.R
import com.jacknic.android.navigation.util.Preference


/**
 * 首页
 */
class HomePage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        val btnLogout = view.findViewById<View>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            val preference = Preference(requireContext())
            preference.logined = false
            navController.navigate(R.id.action_homePage_to_startPage)
        }
    }

}
