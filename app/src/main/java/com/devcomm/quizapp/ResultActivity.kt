package com.devcomm.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    lateinit var tv : TextView
    lateinit var tv2 : TextView
    lateinit var tv3 : TextView
    lateinit var btnRestart : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val correct = intent.getIntExtra("correctAnswers",0)
        val incorrect = intent.getIntExtra("incorrectAnswers",0)
        val final = correct

        tv = findViewById(R.id.tvres)
        tv2 = findViewById(R.id.tvres2)
        tv3 = findViewById(R.id.tvres3)
        btnRestart = findViewById(R.id.btnRestart)

        val sb = StringBuffer()
        sb.append("Correct answers: $correct \n}")
        val sb2 = StringBuffer()
        sb2.append("Wrong Answers: $incorrect \n")
        val sb3 = StringBuffer()
        sb3.append("Final Score: $final\n")

        tv.setText(sb)
        tv2.setText(sb2)
        tv3.setText(sb3)

//        QuestionsActivity.correct = 0
//        QuestionsActivity.wrong = 0

        btnRestart.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}