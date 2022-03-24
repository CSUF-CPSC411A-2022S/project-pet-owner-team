package com.example.cpsc411petownerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var clearButton: Button
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val name: EditText = findViewById(R.id.medication)
            val address: EditText = findViewById(R.id.dosage)
            val addButton: EditText = findViewById(R.id.time)
            addButton.setOnClickListener {
                val toast = Toast.makeText(this, "Adding...", Toast.LENGTH_SHORT)
                toast.show()
            }
            clearButton = findViewById(R.id.clear)
            clearButton.setOnClickListener {
                name.setText("")
                address.setText("")
            }
        }
    }
}