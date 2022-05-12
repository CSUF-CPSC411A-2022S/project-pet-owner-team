package com.example.cpsc411petownerapp.database.medicationData

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicationViewModel(application: Application) : AndroidViewModel(application) {
    private val readMedicationData: LiveData<List<Medication>>
    private val repository: MedicationRepository

    init {
        val medicationDao = MedicationDatabase.getInstance(application).medicationDao()
        repository = MedicationRepository(medicationDao)
        readMedicationData = repository.readMedicationData
    }

    fun addMedication(medication: Medication){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMedication(medication)
        }
    }
}