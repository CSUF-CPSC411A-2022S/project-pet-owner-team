package com.example.cpsc411petownerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cpsc411petownerapp.R
import org.w3c.dom.Text

class UserAdapter (
    private val context: Context,
    var dataset: MutableList<Person> = mutableListOf<Person>()
) : RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {


    //Inner class to hold the view
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        //References to elements in volunteer_list_item.xml so it can modify them.
        val name: TextView = view.findViewById(R.id.name)
        val position: TextView = view.findViewById(R.id.position)
        val address: TextView = view.findViewById(R.id.address)
        val sex : TextView = view.findViewById(R.id.sex)
        val phoneNumber: TextView = view.findViewById(R.id.phoneNumber)
        val age: TextView = view.findViewById(R.id.age)
        val petType: TextView = view.findViewById(R.id.petType)
        val petAge : TextView = view.findViewById(R.id.petAge)
        val petName: TextView = view.findViewById(R.id.petName)

    }


    /** Implement the three required methods for a RecyclerView adapter. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        //Use inflater based on the parent to create the view in the correct position
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)

        // Create and return an ItemViewHolder object using the layout we inflated.
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        //Retrieve the corresponding volunteer name from the dataset
        //so it is displayed in the correct position of the RecyclerView
        val item = dataset[position]

        //Change the values of the elements in the layout according to the data values
        //Use the position parameter to show numbering.
        holder.position.text = (position + 1).toString() + "."
        holder.name.text = item.name
        holder.address.text = item.address
        holder.sex.text = item.sex
        holder.phoneNumber.text = item.phoneNumber
        holder.age.text = item.age.toString()
        holder.petType.text = item.petType
        holder.petAge.text = item.petAge
        holder.petName.text = item.petName

    }

    // Retrieves the amount of data inside the data set.
    override fun getItemCount(): Int = dataset.size

}