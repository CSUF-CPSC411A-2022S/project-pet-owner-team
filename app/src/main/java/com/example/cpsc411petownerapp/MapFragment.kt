package com.example.cpsc411petownerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.cpsc411petownerapp.databinding.MapFragmentBinding
import com.example.cpsc411petownerapp.geocoding.GeocodingViewModel

/**
 * Main application interface.
 *
 */
class MapFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: MapFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.map_fragment,
            container,false)

        val model = GeocodingViewModel()
        binding.geoCodingViewModel = model
        binding.lifecycleOwner = this
        // Make sure our BindingAdapters are connected
        binding.executePendingBindings()

        return binding.root
    }
}