package com.example.cpsc411petownerapp.todoitem
import android.app.Application
import androidx.lifecycle.*
import com.example.cpsc411petownerapp.database.todoData.TodoDao

/**
 * TodoViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values. It retrieves the corresponding intersection
 * with the provided intersection ID.
 */
class TodoItemViewModel(
    val taskId: Long,
    val database: TodoDao, // Data access object for the TD entity
    application: Application
) : AndroidViewModel(application) {

    // Retrieves a LiveData-wrapped intersection object given its ID
    val todo = database.get(taskId)
}