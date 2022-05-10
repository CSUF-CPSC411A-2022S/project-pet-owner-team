package com.example.cpsc411petownerapp.database.todoData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class that represents an To-do entity. It describes the columns of its corresponding table.
 */
@Entity(tableName = "todo_table")
data class Todo(

    // Defines the table's primary key. Primary keys are unique values that can be autogenerated.
    // They are used to differentiate one entity from another.
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    // Non-rprimary key column. Data type is specified in the property.
    @ColumnInfo()
    var title: String = "",

    // Non-rprimary key column. Data type is specified in the property.
    @ColumnInfo()
    var detail: String = ""
)
