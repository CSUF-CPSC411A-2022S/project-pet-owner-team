package com.example.cpsc411petownerapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cpsc411petownerapp.database.UserData.UserDatabase
import com.example.cpsc411petownerapp.databinding.FragmentMedicationBinding
import com.example.cpsc411petownerapp.databinding.LoginBinding
import com.example.cpsc411petownerapp.databinding.MenuBinding
import com.example.cpsc411petownerapp.userViewModel.UserViewModel
import com.example.cpsc411petownerapp.userViewModel.UserViewModelFactory


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MedicationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class MedicationFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        /*/=== Coded added here by aaliyah ===
        // medication fragment stuff
        val medication: EditText? = view?.findViewById(R.id.medication)
        val dosage: EditText? = view?.findViewById(R.id.dosage)
        val time: EditText? = view?.findViewById(R.id.time)
        val add: Button? = view?.findViewById((R.id.add))
        add?.setOnClickListener {
            val toast = Toast.makeText(context, "adding stuff", Toast.LENGTH_SHORT)
            toast.show()
        }
        // === end aaliyah code ===
        */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMedicationBinding.inflate(inflater)
        binding.add.setOnClickListener { view: View ->
            Toast.makeText(context, "adding stuff", Toast.LENGTH_SHORT).show()
        }
        //Toast.makeText(context, "adding stuff", Toast.LENGTH_SHORT).show()

        return binding.root
        //return inflater.inflate(R.layout.fragment_medication, container, false)
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MedicationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
