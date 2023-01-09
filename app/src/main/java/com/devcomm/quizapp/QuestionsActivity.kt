package com.devcomm.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

open class QuestionsActivity : AppCompatActivity() {

    private lateinit var txtView: TextView
    private lateinit var submitButton: Button
    private lateinit var quitButton: Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var rb3: RadioButton
    private lateinit var rb4: RadioButton

    private var questions = arrayOf(
        "Which method can be defined only once in a program?",
        "Which of these is not a bitwise operator?",
        "Which keyword is used by method to refer to the object that invoked it?",
        "Which of these keywords is used to define interfaces in Java?",
        "Which of these access specifiers can be used for an interface?",
        "Which of the following is correct way of importing an entire package ‘pkg’?",
        "What is the return type of Constructors?",
        "Which of the following package stores all the standard java classes?",
        "Which of these method of class String is used to compare two String objects for their equality?",
        "An expression involving byte, int, & literal numbers is promoted to which of these?"
    )
    private var answers = arrayOf(
        "main method",
        "<=",
        "this",
        "interface",
        "public",
        "import pkg.*",
        "None of the mentioned",
        "java",
        "equals()",
        "int"
    )
    private var opt = arrayOf(
        "finalize method",
        "main method",
        "static method",
        "private method",
        "&",
        "&=",
        "|=",
        "<=",
        "import",
        "this",
        "catch",
        "abstract",
        "Interface",
        "interface",
        "intf",
        "Intf",
        "public",
        "protected",
        "private",
        "All of the mentioned",
        "Import pkg.",
        "import pkg.*",
        "Import pkg.*",
        "import pkg.",
        "int",
        "float",
        "void",
        "None of the mentioned",
        "lang",
        "java",
        "util",
        "java.packages",
        "equals()",
        "Equals()",
        "isequal()",
        "Isequal()",
        "int",
        "long",
        "byte",
        "float"
    )
    private var flag = 0
    open var marks = 0
    open var correct = 0
    open var wrong = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val score: TextView = findViewById(R.id.textView4)
        val textView: TextView = findViewById(R.id.DispName)
        val intent1 = intent
        val name = intent1.getStringExtra("myName")

        if (name == "") {
            "Hello User".also { textView.text = it }
        } else {
            "Hello $name".also { textView.text = it }
        }

        submitButton = findViewById(R.id.button3)
        quitButton = findViewById(R.id.buttonquit)
        txtView = findViewById(R.id.tvque)

        radioGroup = findViewById(R.id.answersgrp)
        rb1 = findViewById(R.id.radioButton1)
        rb2 = findViewById(R.id.radioButton2)
        rb3 = findViewById(R.id.radioButton3)
        rb4 = findViewById(R.id.radioButton4)

        txtView.text = questions[flag]
        rb1.text = opt[0]
        rb2.text = opt[1]
        rb3.text = opt[2]
        rb4.text = opt[3]

        submitButton.setOnClickListener(View.OnClickListener {

            if (radioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(applicationContext, "Please select one choice", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }

            val uAns: RadioButton = findViewById(radioGroup.checkedRadioButtonId)
            val ansText = uAns.text.toString()

            if (ansText == answers[flag]) {
                correct++
                Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                wrong++
                Toast.makeText(applicationContext, "Wrong", Toast.LENGTH_SHORT).show()
            }

            flag++

            if (score != null) {
                score.text = "$correct"
            }

            if (flag < questions.size) {
                txtView.text = questions[flag]
                rb1.text = opt[flag * 4]
                rb2.text = opt[flag * 4 + 1]
                rb3.text = opt[flag * 4 + 2]
                rb4.text = opt[flag * 4 + 3]
            } else {
                marks = correct
                val correctAnswers = correct
                val incorrectAnswers = wrong
                val intent2 = Intent(this@QuestionsActivity, ResultActivity::class.java)
                intent.putExtra("correctAnswers", correctAnswers)
                intent.putExtra("incorrectAnswers", incorrectAnswers)
                startActivity(intent2)
            }
            radioGroup.clearCheck()
        })

        quitButton.setOnClickListener {
            val intent3 = Intent(this@QuestionsActivity, ResultActivity::class.java)
            startActivity(intent3)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}