package com.example.cpsc411petownerapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.example.cpsc411petownerapp.userViewModel.UserViewModel
import com.example.cpsc411petownerapp.userViewModel.UserViewModelFactory
import com.example.cpsc411petownerapp.databinding.LoginBinding
import com.example.cpsc411petownerapp.database.UserData.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.login, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve User data access object.
        val dataSource = UserDatabase.getInstance(application).userDao

        // Create a factory that generates UserViewModels connected to the database.
        val viewModelFactory = UserViewModelFactory(dataSource, application)

        // Generate an UserViewModel using the factory.
        val userViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(UserViewModel::class.java)

        // Connect the UserViewModel with the variable in the layout
        binding.userViewModel = userViewModel

        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        binding.signIn.setOnClickListener { view: View ->
            var valid = false
            if (valid) {
                val toast = Toast.makeText(activity, "Successfully Login as ${binding.username.text}", Toast.LENGTH_SHORT)
                toast.show()
                // Show the menu fragment after the user logged in
                    view.findNavController()
                        .navigate(LoginDirections
                            .actionLoginToMenu(binding.username.text.toString()))
            } else {
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