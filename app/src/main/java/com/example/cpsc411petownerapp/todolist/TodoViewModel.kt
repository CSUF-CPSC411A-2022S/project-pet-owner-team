package com.example.cpsc411petownerapp.todolist

import android.app.Application
import androidx.lifecycle.*
import com.example.cpsc411petownerapp.database.todoData.Todo
import com.example.cpsc411petownerapp.database.todoData.TodoDao
import kotlinx.coroutines.launch

/**
 * TodoViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values.
 */
class TodoViewModel(
    val database: TodoDao, // Data access object for the To-do entity
    application: Application
) : AndroidViewModel(application) {

    // Used to assign and retrieve name and location values from the interface.
    var title = MutableLiveData("")
    var detail = MutableLiveData("")

    // Retrieves all To-do objects from the database
    // Represented as a LiveData<List<To-do>>
    val todoList = database.getAllTodos()

    /**
     * Inserts the To-do object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create To-do object using data stored in the EditText views
            var todo = Todo()
            todo.title = title.value.toString()
            todo.detail = detail.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(todo)
        }
    }


    /**
     * Deletes all To-do entities in the database.
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