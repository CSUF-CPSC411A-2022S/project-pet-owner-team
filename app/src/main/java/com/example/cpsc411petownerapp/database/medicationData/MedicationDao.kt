package com.example.cpsc411petownerapp.database.medicationData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicationDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMedication(meds: Medication)

    @Query("SELECT * FROM medication_table ORDER BY medication ASC")
    fun readMedicationData() : LiveData<List<Medication>>


}