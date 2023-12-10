package com.hadash.gymtracker.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun callback(view: View) {
        val button = view as? Button ?: return // Casting seguro a Button
        //Toast.makeText(this, button.text, Toast.LENGTH_LONG).show()

        val btnSession = findViewById<Button>(R.id.btn_session)
        val btnShow = findViewById<Button>(R.id.btn_show)
        val btnProf = findViewById<Button>(R.id.btn_prof)

        if (button == btnProf) {
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        if (button == btnShow) {
            intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }

        if (button == btnSession) {
            intent = Intent(this, SessionActivity::class.java)
            startActivity(intent)
        }
    }
}