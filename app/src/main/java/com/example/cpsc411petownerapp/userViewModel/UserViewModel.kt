package com.example.cpsc411petownerapp.userViewModel

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

    /**
     * Inserts the User object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create User object using data stored in the EditText views
            var user = User()
            user.username = username.value.toString()
            user.password = password.value.toString()
            user.email = email.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(user)
        }

    }

    fun checkLogin(username: String, password: String): LiveData<User> {
        return database.login(username, password)
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