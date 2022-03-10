package com.example.cpsc411petownerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cpsc411petownerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Use a binding object to simplify access to the visual design elements.
         */
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = this.findNavController(R.id.nav_host)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }
    
    override fun onSupportNavigateUp(): Boolean {
        // Replace nav_host with the name of your nav host fragment in activity_main.xml
        val navController = this.findNavController(R.id.nav_host)
        return navController.navigateUp()
    }
}
