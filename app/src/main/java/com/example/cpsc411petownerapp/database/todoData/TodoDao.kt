package com.example.cpsc411petownerapp.database.todoData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Data access object for the To-do entity. The class describes how data is
 * stored, updated, retrieved, or deleted from the database.
 */
@Dao
interface TodoDao {
    // Add an to-do entity to a table in the database.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(todo: Todo)

    // Update an to-do entity to a table in the database. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(todo: Todo)

    // Custom query for retrieving a single To-do from a table in the database using
    // its task id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from todo_table WHERE taskId = :key")
    fun get(key: Long): LiveData<Todo>?

    // Custom query for retrieving all To-do entities from a table in the database.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from todo_table ORDER BY taskId DESC")
    fun getAllTodos(): LiveData<List<Todo>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from todo_table")
    suspend fun clear()
}