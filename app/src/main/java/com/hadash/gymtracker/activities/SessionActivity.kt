package com.hadash.gymtracker.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class SessionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)

        val spinner_ex: Spinner = findViewById(R.id.exercises)
        ArrayAdapter.createFromResource(
            this,
            R.array.exercises_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_ex.adapter = adapter
        }

        val repsList = ArrayList<Int>()
        for (i in 5..30) {
            repsList.add(i)
        }

//        val spinner_reps: Spinner = findViewById(R.id.reps)
//        val adapter = ArrayAdapter(this, android.R.layo)


    }
}