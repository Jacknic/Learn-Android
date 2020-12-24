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
 * 登录页
 */
class LoginPage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnLogin = view.findViewById<View>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
//            navController.popBackStack()
            val preference = Preference(requireContext())
            preference.logined = true
            navController.navigate(R.id.action_loginPage_to_homePage)
        }
    }
}
