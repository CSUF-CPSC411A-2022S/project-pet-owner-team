package com.example.cpsc411petownerapp

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import android.widget.Toast
import com.example.cpsc411petownerapp.databinding.LoginBinding
import com.example.cpsc411petownerapp.database.UserData.UserDao

class Login() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = LoginBinding.inflate(layoutInflater)

        binding.signIn.setOnClickListener { view: View ->
            if (binding.username.text.toString() == "admin" &&
                binding.password.text.toString() == "admin") {
                    // Show the menu fragment after the user logged in
                    view.findNavController()
                        .navigate(LoginDirections
                            .actionLoginToMenu(binding.username.text.toString()))
                }
            else {
                val toast = Toast.makeText(activity, "Invalid Input. Try Again", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        binding.signUp.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_login_to_register)
        }
        return binding.root
    }
}