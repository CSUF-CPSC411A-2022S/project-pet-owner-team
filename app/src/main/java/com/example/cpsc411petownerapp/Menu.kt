package com.example.cpsc411petownerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.cpsc411petownerapp.databinding.MenuBinding

class Menu : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MenuBinding.inflate(layoutInflater)
        val args = MenuArgs.fromBundle(requireArguments())

        binding.welcomeId.setText("Hi, ${args.name}")

        // View/Edit Button Event
        binding.option1.setOnClickListener() {view: View ->
            view.findNavController()
                .navigate(R.id.action_menu_to_infoListFragment)
        }

        // Health Tracker Button Event
        binding.option2.setOnClickListener() {view: View ->
            view.findNavController()
                .navigate(R.id.action_menu_to_todoListFragment)
        }

        // Medication Button Event
        binding.option3.setOnClickListener() {view: View ->
            view.findNavController()
                .navigate(R.id.action_menu_to_medicationFragment)
        }

        // Vet/Hospital Location Search
        binding.option4.setOnClickListener() {view: View ->
            view.findNavController()
                .navigate(R.id.action_menu_to_mapFragment)
        }

        return binding.root
    }
}
