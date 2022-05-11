package com.example.cpsc411petownerapp.infolist


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
    var age = MutableLiveData("")
    var sex = MutableLiveData("")
    var address = MutableLiveData("")
    var phoneNumber = MutableLiveData("")
    var petType = MutableLiveData("")
    var petAge = MutableLiveData("")
    var petName = MutableLiveData("")

    // Retrieves all Information objects from the database
    // Represented as a LiveData<List<Info>>
    val infoList = database.getAllInfos()

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
            info.age = age.value.toString()
            info.sex = sex.value.toString()
            info.address = address.value.toString()
            info.phoneNumber = phoneNumber.value.toString()
            info.petType = petType.value.toString()
            info.petAge = petAge.value.toString()
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