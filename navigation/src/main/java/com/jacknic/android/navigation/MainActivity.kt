package com.jacknic.android.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.jacknic.android.navigation.util.Preference

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val appBarConfiguration = AppBarConfiguration(setOf(R.id.startPage, R.id.homePage))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        val preference = Preference(this)
        if (preference.logined) {
            navController.navigate(R.id.action_startPage_to_homePage)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}
