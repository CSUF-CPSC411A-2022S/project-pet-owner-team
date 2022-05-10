package com.example.cpsc411petownerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cpsc411petownerapp.userViewModel.UserViewModel
import com.example.cpsc411petownerapp.userViewModel.UserViewModelFactory
import com.example.cpsc411petownerapp.database.UserData.UserDatabase
import com.example.cpsc411petownerapp.databinding.RegisterBinding

class Register : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: RegisterBinding =
            DataBindingUtil.inflate(inflater, R.layout.register, container, false)


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
                userViewModel.insert()
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