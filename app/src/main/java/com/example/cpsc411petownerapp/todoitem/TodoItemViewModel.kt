package com.example.cpsc411petownerapp.todoitem
import android.app.Application
import androidx.lifecycle.*
import com.example.cpsc411petownerapp.database.todoData.TodoDao

/**
 * TodoViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values. It retrieves the corresponding to-do
 * with the provided task ID.
 */
class TodoItemViewModel(
    val taskId: Long,
    val database: TodoDao, // Data access object for the TD entity
    application: Application
) : AndroidViewModel(application) {

    // Retrieves a LiveData-wrapped to-do object given its ID
    val todo = database.get(taskId)
}