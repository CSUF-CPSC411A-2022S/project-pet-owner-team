package com.example.cpsc411petownerapp.infoitem
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cpsc411petownerapp.database.InfoDao

/**
 * Generates an InfoViewModel tied to the database. It uses the provided intersection ID to
 * to create the InfoItemViewModel.
 */
class InfoItemViewModelFactory(
    private val intersectionId: Long,
    private val dataSource: InfoDao, // Data access object
    private val application: Application
): ViewModelProvider.Factory {

    /**
     * Creates the InfoViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfoItemViewModel::class.java)) { // ViewModel class
            return InfoItemViewModel(intersectionId, dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}