package com.example.cpsc411petownerapp.infolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cpsc411petownerapp.database.Info
import com.example.cpsc411petownerapp.databinding.InfoItemBinding

/**
 * A RecyclerView adapter that uses the DiffCallback for better performance and a listener to handle
 * clicks/taps on each item.
 */
class InfoListAdapter(val clickListener: InfoListener) : ListAdapter<Info,
        InfoListAdapter.ItemViewHolder>(InfoDiffCallback()) {

    /**
     * Inner class used to store data about each element in the RecyclerView. We provide a binding
     * to make it easy to access elements of the layout.
     */
    class ItemViewHolder(val binding: InfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Assign an info object and clickListener to the ItemViewHolder
         */
        fun bind(item: Info, clickListener: InfoListener) {
            binding.info = item
            binding.clickListener = clickListener
        }
    }

    /**
     * Creates a View to visualize one element in the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // We use an inflater based on the parent (IntersectionListFragment) and create an
        // ItemViewHolder with binding to the layout to simplify access.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = InfoItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * The function is called whenever the RecyclerView displays a specific element. It provides
     * access to the ItemViewHolder and its position.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Assign the corresponding element from the data and the click listener. Take note getItem
        // is a function provided by ListAdapter.
        holder.bind(getItem(position), clickListener)
    }
}

/**
 * Manages a RecyclerView list using the Eugene W. Myers's difference algorithm to reduce processing.
 */
class InfoDiffCallback : DiffUtil.ItemCallback<Info>() {
    /**
     * We use intersectionId because it is a unique ID referring to a single element.
     */
    override fun areItemsTheSame(oldItem: Info, newItem: Info): Boolean {
        return oldItem.infoId == newItem.infoId
    }

    /**
     * We check all properties to check equality between Intersection objects.
     */
    override fun areContentsTheSame(oldItem: Info, newItem: Info): Boolean {
        return oldItem.name == newItem.name && oldItem.age == newItem.age &&
                oldItem.sex == newItem.sex && oldItem.address == newItem.address &&
                oldItem.phoneNumber == newItem.phoneNumber && oldItem.petType == newItem.petType &&
                oldItem.petAge == newItem.petAge && oldItem.petName == newItem.petName


    }
}

/**
 * Listener that accepts a lambda function clickListener. It will be called when an element of the
 * RecyclerView is clicked/tapped.
 */
class InfoListener(val clickListener: (infoId: Long) -> Unit) {
    fun onClick(info: Info) = clickListener(info.infoId)
}