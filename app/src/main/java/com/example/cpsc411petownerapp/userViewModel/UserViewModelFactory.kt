package com.example.cpsc411petownerapp.userViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cpsc411petownerapp.database.UserData.UserDao

// Create User ViewModelFactory
/**
 * Generates an UserViewModel tied to the database.
 */
class UserViewModelFactory(
    private val dataSource: UserDao, // Data access object
    private val application: Application): ViewModelProvider.Factory {

    /**
     * Creates the UserViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) { // ViewModel class
            return UserViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}