package com.example.cpsc411petownerapp.todolist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cpsc411petownerapp.database.todoData.TodoDao

/**
 * Generates an TodoViewModel tied to the database.
 */
class TodoViewModelFactory(
    private val dataSource: TodoDao, // Data access object
    private val application: Application
) : ViewModelProvider.Factory {

    /**
     * Creates the IntersectionViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) { // ViewModel class
            return TodoViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}