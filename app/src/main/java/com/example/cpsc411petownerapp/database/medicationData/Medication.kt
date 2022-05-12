package com.example.cpsc411petownerapp.database.medicationData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medication_table" )
data class Medication (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val medication: String,
    val dosage: String,
    val time: String,
        ){
}