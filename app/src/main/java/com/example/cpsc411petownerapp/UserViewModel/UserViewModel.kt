package com.example.cpsc411petownerapp.UserViewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.cpsc411petownerapp.database.UserData.UserDao
import com.example.cpsc411petownerapp.database.UserData.User
import kotlinx.coroutines.launch

// Create User ViewModel
class UserViewModel(
    val database: UserDao, // Data access object for the User entity
    application: Application) : AndroidViewModel(application) {

    var username = MutableLiveData("")
    var password = MutableLiveData("")
    var email = MutableLiveData("")

    // Retrieves all User objects from the database
    // Represented as a LiveData<List<User>>
    val userList = database.getAllUsers()

    /**
     * Creates a LiveData<String> that contains information from all User objects.
     * The Transformations.map function takes a LiveData object, performs operations on the
     * object and returns a LiveData-wrapped object.
     */
    var profileString = Transformations.map(userList) {
            users -> // profiles refer to the underlying data List<User>
        var result = ""
        // Retrieve each User object from the list
        for (user in users) {
            // Create a string using the User name and email address.
            // The user string is appended to a longer string with all profiles.
            result += "${user.username} (${user.email})\n"
        }
        // Returns the aggregated String that is wrapped by the map function in a LiveData object.
        result
    }

    /**
     * Inserts the User object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create Intersection object using data stored in the EditText views
            var user = User()
            user.username = username.value.toString()
            user.password = password.value.toString()
            user.email = email.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(user)
        }

    }

    /**
     * Deletes all User entities in the database.
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