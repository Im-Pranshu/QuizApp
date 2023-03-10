package com.devcomm.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// activity for the developer info
class DeveloperActivity : AppCompatActivity() {
    lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)

        btnBack = findViewById(R.id.btnBack)

        // adding back click
        btnBack.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    // here is onPause function
    override fun onPause() {
        super.onPause()
        finish()
    }
}