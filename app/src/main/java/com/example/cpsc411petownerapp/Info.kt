package com.example.cpsc411petownerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cpsc411petownerapp.UserAdapter
import com.example.cpsc411petownerapp.databinding.InfoBinding

class Info : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.info, container, false)

        // Inflate and bind the profile.xml layout for the Profile fragment
        val binding = InfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RecyclerView adapter object and assign it to the RecyclerView.
        var userAdapter = UserAdapter(this)
        binding.userList.adapter = userAdapter

        val str = binding.age.toString()
        val age = str.toInt()

        var person = User(
            age,
            address = binding.address.toString(),
            sex = binding.sex.toString(),
            name = binding.name.toString(),
            phoneNumber = binding.phoneNumber.toString(),
            petType = binding.petType.toString(),
            petAge = binding.petAge.toString(),
            petName = binding.petName.toString()
        )

        //Handle onClick events on the "Add Volunteer" button.
        binding.add.setOnClickListener {

            //Toast object to display the appropriate message
            val toast = Toast.makeText(
                this,
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
    }

}