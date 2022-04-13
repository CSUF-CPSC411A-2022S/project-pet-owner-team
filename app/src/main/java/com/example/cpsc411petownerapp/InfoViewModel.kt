package com.example.cpsc411petownerapp


import android.app.Application
import androidx.lifecycle.*
import com.example.cpsc411petownerapp.database.Info
import com.example.cpsc411petownerapp.database.InfoDao
import kotlinx.coroutines.launch

/**
 * InfoViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values.
 */
class InfoViewModel(
    val database: InfoDao, // Data access object for the Intersection entity
    application: Application) : AndroidViewModel(application) {

    var name = MutableLiveData("")
    var age = MutableLiveData(0)
    var sex = MutableLiveData("")
    var address = MutableLiveData("")
    var phoneNumber = MutableLiveData("")
    var petType = MutableLiveData("")
    var petAge = MutableLiveData(0)
    var petName = MutableLiveData("")

    // Retrieves all Information objects from the database
    // Represented as a LiveData<List<Info>>
    val infoList = database.getAllInfos()

    /**
     * Creates a LiveData<String> that contains information from all Info objects.
     * The Transformations.map function takes a LiveData object, performs operations on the
     * object and returns a LiveData-wrapped object.
     */
    var infoString = Transformations.map(infoList) {
            infos -> // infos refer to the underlying data List<Info>
        var result = ""
        // Retrieve each Info object from the list
        for (info in infos) {
            // Create a string using the Info name,age, sex, address, phone number
                //pet type, pet age, and pet name .
            // The information string is appended to a longer string with all profiles.
            result += "${info.name} ${info.age}\n"
        }
        // Returns the aggregated String that is wrapped by the map function in a LiveData object.
        result
    }

    /**
     * Inserts the Info object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create Intersection object using data stored in the EditText views
            var info = Info()
            info.name = name.value.toString()
            val str1 = age.value.toString()
            info.age = str1.toInt()
            info.sex = sex.value.toString()
            info.address = address.value.toString()
            info.phoneNumber = phoneNumber.value.toString()
            info.petType = petType.value.toString()
            val str2 = petAge.value.toString()
            info.petAge = str2.toInt()
            info.petName = petName.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(info)
        }

    }

    /**
     * Deletes all Profile entities in the database.
     */
    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}