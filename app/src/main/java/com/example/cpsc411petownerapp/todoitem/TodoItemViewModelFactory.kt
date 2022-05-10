package com.example.cpsc411petownerapp.todoitem
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cpsc411petownerapp.database.todoData.TodoDao

/**
 * Generates an TodoViewModel tied to the database. It uses the provided task ID to
 * to create the TodoItemViewModel.
 */
class TodoItemViewModelFactory(
    private val taskId: Long,
    private val dataSource: TodoDao, // Data access object
    private val application: Application
): ViewModelProvider.Factory {

    /**
     * Creates the TodoViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoItemViewModel::class.java)) { // ViewModel class
            return TodoItemViewModel(taskId, dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}