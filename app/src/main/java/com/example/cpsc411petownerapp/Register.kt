package com.example.cpsc411petownerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.cpsc411petownerapp.databinding.RegisterBinding

class Register : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate and bind the register.xml layout for the Register fragment
        val binding = RegisterBinding.inflate(layoutInflater)

        /**
         * Add setOnClickListener to the Calculate button that navigates from HealthTracker to
         * Result fragment
         */
        binding.submit.setOnClickListener { view: View ->
            if (binding.username.text.toString() != "" &&
                binding.userPassword.text.toString() != "" &&
                binding.emailAddress.text.toString() != ""
            ) {
                val toast = Toast.makeText(activity, "Successfully Register.", Toast.LENGTH_SHORT)
                toast.show()
                binding.username.text.clear()
                binding.userPassword.text.clear()
                binding.emailAddress.text.clear()
            } else {
                val toast = Toast.makeText(activity, "Fail! Missing Input.", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        return binding.root
    }
}