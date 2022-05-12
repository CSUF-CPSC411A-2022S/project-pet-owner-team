package com.example.cpsc411petownerapp

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cpsc411petownerapp.database.UserData.UserDatabase
import com.example.cpsc411petownerapp.database.medicationData.Medication
import com.example.cpsc411petownerapp.database.medicationData.MedicationViewModel
import com.example.cpsc411petownerapp.databinding.FragmentMedicationBinding
import com.example.cpsc411petownerapp.databinding.LoginBinding
import com.example.cpsc411petownerapp.databinding.MenuBinding
import com.example.cpsc411petownerapp.userViewModel.UserViewModel
import com.example.cpsc411petownerapp.userViewModel.UserViewModelFactory

class MedicationFragment : Fragment() {
    lateinit var mMedicationViewModel: MedicationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {

        // setup bindings
        val binding = FragmentMedicationBinding.inflate(inflater)

        val addButton: Button = binding.add
        val clearButton: Button = binding.clear

        val medicationField: EditText = binding.medication
        val dosageField: EditText = binding.dosage
        val timeField: EditText = binding.time

        mMedicationViewModel = ViewModelProvider(this).get(MedicationViewModel::class.java)

        // add button listener
        addButton.setOnClickListener { _: View ->
            //add variables into database
            insertMedToDatabase(
                    medicationField.text.toString(),
                    dosageField.text.toString(),
                    timeField.text.toString()
            )

        }

        // clear button listener
        clearButton.setOnClickListener { _: View ->
            // code to clear text fields
            medicationField.text.clear()
            dosageField.text.clear()
            timeField.text.clear()

            // toast for visual feedback on button press
            Toast.makeText(context, "Cleared fields", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    // function to add items to medication database
    private fun insertMedToDatabase(medication: String, dosage: String, time: String) {

        // if fields not empty add to database, else give error
        if (inputCheck(medication,dosage,time)){
            val m = Medication(0, medication, dosage, time)
            mMedicationViewModel.addMedication(m)

            //toast for visual feedback
            Toast.makeText(context, "Medication \"${medication}\" added!", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Please enter each field.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(meds: String, dose: String, t: String): Boolean {
        return !(TextUtils.isEmpty(meds) && TextUtils.isEmpty(dose) && TextUtils.isEmpty(t))
    }


}
