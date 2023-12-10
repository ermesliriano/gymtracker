package com.hadash.gymtracker.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class SessionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)

        val spinnerEx: Spinner = findViewById(R.id.exercises)
        ArrayAdapter.createFromResource(
            this,
            R.array.exercises_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerEx.adapter = adapter
        }

        val spinnerKg: Spinner = findViewById(R.id.weights)
        ArrayAdapter.createFromResource(
            this,
            R.array.weight_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerKg.adapter = adapter
        }

        val repsList = ArrayList<Int>()
        for (i in 5..30) {
            repsList.add(i)
        }

        val spinnerReps: Spinner = findViewById(R.id.reps)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, repsList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerReps.adapter = adapter

    }
}