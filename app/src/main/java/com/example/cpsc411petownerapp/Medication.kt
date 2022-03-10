package com.example.cpsc411petownerapp

abstract class Medication {
    abstract var medicationName: String
    abstract var dosage: Int
    abstract var time: Int

    // this method will take as input the time and medication name, will display a reminder message
    // at the appropriate time
    abstract fun reminder(medication: String, time: Int)
}