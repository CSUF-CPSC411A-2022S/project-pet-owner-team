package com.example.cpsc411petownerapp.database.medicationData

import androidx.lifecycle.LiveData

class MedicationRepository(private val medicationDao: MedicationDao) {
    val readMedicationData: LiveData<List<Medication>> = medicationDao.readMedicationData()

    suspend fun addMedication(medication: Medication) {
        medicationDao.addMedication(medication)
    }

}