package com.example.cpsc411petownerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cpsc411petownerapp.UserAdapter
import com.example.cpsc411petownerapp.database.InfoDatabase
import com.example.cpsc411petownerapp.databinding.InfoBinding

// Constant that stores the key for storing and retrieving error message data.
const val KEY_ERROR = "error"

class Info : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate and bind the profile.xml layout for the Profile fragmentval
         val binding: InfoBinding = DataBindingUtil.inflate(inflater, R.layout.info, container, false)
        //RecyclerView adapter object and assign it to the RecyclerView.
        var userAdapter = UserAdapter(requireContext())
        binding.userList.adapter = userAdapter

        // Get reference to this application
        val application = requireNotNull(this.activity).application


        // Retrieve Intersection data access object.
        val dataSource = InfoDatabase.getInstance(application).infoDao

        // Create a factory that generates InfoViewModels connected to the database.
        val viewModelFactory = InfoViewModelFactory(dataSource, application)


        /*// savedInstanceState is only null the first time the View is created.
        if (savedInstanceState != null) {
            *//**
             * Restore the error message from the saved data. Bundles behave
             * like a map where we use the KEY_ERROR constant (equal to "error")
             * to retrieve the previously stored error message.
             *//*
            binding.errorMsg.setText(savedInstanceState.getString(KEY_ERROR))
        }

        //Handle onClick events on the "Add" button.
        binding.add.setOnClickListener {
            var errorMessage = ""
            //Display an error if there are no inputs
            if (binding.name.text.length == 0 || binding.address.text.length == 0 ||
                binding.sex.text.length == 0 || binding.age.text.length == 0 ||
                binding.phoneNumber.text.length == 0 || binding.petType.text.length == 0 ||
                binding.petAge.text.length == 0 || binding.petName.text.length == 0
            ) {

                errorMessage = "Please provide name, address, sex, age, pet type, " +
                        "pet age, and pet name ";

            } else {

                val strtoint1 = binding.age.text.toString()
                val age = strtoint1.toInt()

                val strtoint2 = binding.petAge.text.toString()
                val petAge = strtoint2.toInt()


                var person = User(
                    age,
                    address = binding.address.text.toString(),
                    sex = binding.sex.text.toString(),
                    name = binding.name.text.toString(),
                    phoneNumber = binding.phoneNumber.text.toString(),
                    petType = binding.petType.text.toString(),
                    petAge,
                    petName = binding.petName.text.toString()
                )

                //Toast object to display the appropriate message
                val toast = Toast.makeText(
                    requireContext(),
                    "Adding ${binding.name.text}${binding.address.text}${binding.sex.text}" +
                            " ${binding.phoneNumber.text} ${binding.age.text}${binding.petType.text}" +
                            " ${binding.petAge.text} ${binding.petName.text}",
                    Toast.LENGTH_SHORT
                )
                toast.show()

                //Add the volunteer to the mutableList and notify the RecyclerView about the change.
                userAdapter.dataset.add(person)

                // Inform the adapter that we made changes so the visual representation can be updated.
                userAdapter.notifyDataSetChanged()


            }
            // Replace the TextView with errorMessage's value, which may or may not be empty.
            binding.errorMsg.setText(errorMessage)
        }*/

        // Generate an ProfileViewModel using the factory.
        val infoViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(InfoViewModel::class.java)

        // Connect the ProfileViewModel with the variable in the layout
        binding.infoViewModel = infoViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        infoViewModel.infoList.observe(viewLifecycleOwner, Observer {
            it?.let {
                userAdapter.submitList(it)
            }
        })
         return binding.root

        }

}

