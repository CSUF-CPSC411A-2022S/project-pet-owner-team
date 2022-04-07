package com.example.cpsc411petownerapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class that represents an Intersection entity. It describes the columns of its corresponding
 * table.
 *
 * Data classes are special classes with the primary purpose of storing data. Properties are often
 * declared in the primary constructor and the body is left empty.
 *
 * Kotlin uses annotations to provide information to the compiler for generating code.They begin
 * with an @ and are written above a function, property, or parameter.
 */
@Entity(tableName = "profile_table")
data class Info(

    // Defines the table's primary key. Primary keys are unique values that can be autogenerated.
    // They are used to differentiate one entity from another.
    @PrimaryKey(autoGenerate = true)
    var infoId: Long = 0L,

    // Non-primary key column. Data type is specified in the property.
    @ColumnInfo()
    var name: String = "",

    // Non-primary key column. Data type is specified in the property.
    @ColumnInfo()
    var age: String = "",

    // Non-primary key column. Data type is specified in the property.
    @ColumnInfo()
    var sex: String = "",

    // Non-primary key column. Data type is specified in the property.
    @ColumnInfo()
    var address: String = "",

    // Non-primary key column. Data type is specified in the property.
    @ColumnInfo()
    var phoneNumber: String = "",

    // Non-primary key column. Data type is specified in the property.
    @ColumnInfo()
    var petType: String = "",

    // Non-primary key column. Data type is specified in the property.
    @ColumnInfo()
    var petAge: String = "",

    // Non-primary key column. Data type is specified in the property.
    @ColumnInfo()
    var petName: String = "",

)
