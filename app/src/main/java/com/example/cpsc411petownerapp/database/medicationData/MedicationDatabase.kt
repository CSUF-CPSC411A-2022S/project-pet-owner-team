package com.example.cpsc411petownerapp.database.medicationData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Medication::class], version = 1, exportSchema = false)
abstract class MedicationDatabase : RoomDatabase(){
    abstract fun medicationDao(): MedicationDao

    companion object {
        // create reference to database
        @Volatile
        private var INSTANCE: MedicationDatabase? = null

        // gets instance of database from context
        fun getInstance(context: Context): MedicationDatabase{
            // keeps threads synchronised
            synchronized(this){
                //create local var of instance to smart cast
                var instance = INSTANCE

                // initial instance is null because it doesn't exist, so create new instance
                // if it already exists just return the current instance
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MedicationDatabase::class.java,
                        "medication_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                // return current instance of database
                return instance
            } // end of sync
        }

    }
}