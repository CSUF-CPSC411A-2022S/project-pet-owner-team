//package com.example.cpsc411petownerapp
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.findNavController
//import com.example.cpsc411petownerapp.databinding.HealthTrackerBinding
//
//class HealthTracker : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate and bind the health_tracker.xml layout for the HealthTracker fragment
//        val binding = HealthTrackerBinding.inflate(layoutInflater)
//
//        /**
//         * Add setOnClickListener to the Calculate button that navigates from HealthTracker to
//         * Result fragment
//         */
//        binding.calculate.setOnClickListener { view: View ->
//            if (binding.breed.text.toString() != "" &&
//                binding.age.text.toString() != "" &&
//                binding.weight.text.toString() != "") {
//                    // Show the result fragment if the user changed their values
//                    view.findNavController()
//                        .navigate(R.id.action_healthTracker_to_result)
//            }
//        }
//        // Return a link to the layout root
//        return binding.root
//    }
//}