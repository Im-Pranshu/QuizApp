package com.devcomm.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btnStartQuiz : Button
    lateinit var btnAbout : Button
    lateinit var etName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartQuiz = findViewById(R.id.btnStartQuiz)
        btnAbout = findViewById(R.id.btnAbout)
        etName = findViewById(R.id.etName)

        btnStartQuiz.setOnClickListener {
            val name: String = etName.text.toString()
            val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
            intent.putExtra("myName", name)
            startActivity(intent)
        }

        btnAbout.setOnClickListener {
            val intent = Intent(applicationContext, DeveloperActivity::class.java)
            startActivity(intent)
        }
    }
}