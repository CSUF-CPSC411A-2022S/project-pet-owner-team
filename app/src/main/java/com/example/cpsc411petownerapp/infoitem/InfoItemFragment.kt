package com.example.cpsc411petownerapp.infoitem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cpsc411petownerapp.R
import com.example.cpsc411petownerapp.database.InfoDatabase
import com.example.cpsc411petownerapp.databinding.InfoItemFragmentBinding
import com.example.cpsc411petownerapp.infolist.InfoViewModel
import com.example.cpsc411petownerapp.infolist.InfoViewModelFactory

/**
 * Fragment that displays a single intersection.
 */
class InfoItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve arguments passed from the RecyclerView
        val args = InfoItemFragmentArgs.fromBundle(
            requireArguments()
        )

        // Create data binding
        val binding: InfoItemFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.info_item_fragment, container, false)

        // Get reference to this application
        val application = requireNotNull(this.activity).application

        // Retrieve Intersection data access object.
        val dataSource = InfoDatabase.getInstance(application).infoDao

        // Create a factory that generates an IntersectionViewModel connected to the database. The
        // intersectionId passed from the RecyclerView is used to display the corresponding
        // information.
        val viewModelFactory =
            InfoItemViewModelFactory(args.infoId, dataSource, application)

        // Generate an IntersectionViewModel using the factory.
        val infoItemViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(InfoItemViewModel::class.java)

        // Connect the IntersectionViewModel with the variable in the layout
        binding.infoItemViewModel = infoItemViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        return binding.root
    }
}



