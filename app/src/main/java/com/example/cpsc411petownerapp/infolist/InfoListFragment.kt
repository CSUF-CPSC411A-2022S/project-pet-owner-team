package com.example.cpsc411petownerapp.infolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cpsc411petownerapp.R
import com.example.cpsc411petownerapp.database.InfoDatabase
import com.example.cpsc411petownerapp.databinding.InfoListFragmentBinding


/**
 * Fragment that displays the input text fields and intersection list
 */
class InfoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create data binding
        val binding: InfoListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.info_list_fragment, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve Intersection data access object.
        val dataSource = InfoDatabase.getInstance(application).infoDao

        // Create a factory that generates IntersectionViewModels connected to the database.
        val viewModelFactory = InfoViewModelFactory(dataSource, application)

        // Generate an IntersectionViewModel using the factory.
        val infoViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(InfoViewModel::class.java)

        // Connect the InfoViewModel with the variable in the layout
        binding.infoViewModel = infoViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        // Provide a lambda function that is called when the RecyclerView item is selected.
        var infoAdapter = InfoListAdapter(InfoListener {
                infoId ->
            // Navigate to the intersection view and provide the id of the info referenced
            // by the select RecyclerView item.
            this.findNavController().navigate(
                InfoListFragmentDirections
                    .actionInfoListFragmentToInfoItemFragment(infoId)
            )
        })
        // Attach intersection adapter.
        binding.infoRecyclerview.adapter = infoAdapter

        // Submit an updated list to the info listAdapter whenever it changes. Take note
        // infoList is a LiveData object.
        infoViewModel.infoList.observe(viewLifecycleOwner, Observer {
            it?.let {
                infoAdapter.submitList(it)
            }
        })
        return binding.root
    }
}