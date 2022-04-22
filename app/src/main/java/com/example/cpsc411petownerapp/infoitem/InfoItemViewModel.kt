package com.example.cpsc411petownerapp.infoitem

import android.app.Application
import androidx.lifecycle.*
import com.example.cpsc411petownerapp.database.InfoDao

/**
 * InfoViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values. It retrieves the corresponding info
 * with the provided info ID.
 */
class InfoItemViewModel(
    val infoId: Long,
    val database: InfoDao, // Data access object for the Intersection entity
    application: Application
) : AndroidViewModel(application) {

    // Retrieves a LiveData-wrapped intersection object given its ID
    val info = database.get(infoId)
}