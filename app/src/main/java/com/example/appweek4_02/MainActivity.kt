package com.example.appweek4_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions : ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setUpViews()

    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("Es Buenos Aires capital de Argentina?", true)
        questions.add(question)
        questions.add(Question("El professor se llama David Quevedo?", true))
        questions.add(Question("Patricia ensenia algoritmos?", false))
        questions.add(Question("Es bueno dormir tarde?", false))
        questions.add(Question("Piero es delegado de complejidad?", true))
    }

    private fun updateNumberQuestion(){

    }

    private fun updatePoint(){

    }

    private fun setUpViews() {
        //Set Up Number Question
        val tvNumber = findViewById<TextView>(R.id.tvNumber)
        var num = position +1
        tvNumber.text = num.toString()

        //Set Up NickName
        val nickname = intent.getStringExtra(EXTRA_NAME)
        this.findViewById<TextView>(R.id.tvNickname).apply{
            text = nickname
        }

        //Set Up the Score
        val tvScorePoint = findViewById<TextView>(R.id.tvScorePoint)
        var point = 0
        tvScorePoint.text = point.toString()

        val tvPointHealth = findViewById<TextView>(R.id.tvPointHealth)
        var healthPoint = Integer.parseInt(tvPointHealth.text.toString())

        val btSi = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)

        var tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.text = questions[position].sentence

        btSi.setOnClickListener {
            if (questions[position].answer){
                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_LONG).show()
                point+=1
                tvScorePoint.text = point.toString()
            }
            else {
                Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_LONG).show()
                healthPoint-=1
                tvPointHealth.text = healthPoint.toString()
            }
            btNo.setEnabled(false)
            btSi.setEnabled(false)
        }


        btNo.setOnClickListener {
            if (!questions[position].answer){
                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_LONG).show()
                point+=1
                tvScorePoint.text = point.toString()
            }
            else {
                Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_LONG).show()
                healthPoint-=1
                tvPointHealth.text = healthPoint.toString()
            }
            btNo.setEnabled(false)
            btSi.setEnabled(false)
        }


        val btNext = findViewById<Button>(R.id.btNext)

        btNext.setOnClickListener {
            if (position < questions.size - 1){
                position += 1
                num+=1
                tvNumber.text = num.toString()
            }
            else {
                btNext.setText("Finish")
            }
            btNo.setEnabled(true)
            btSi.setEnabled(true)

            tvQuestion.text = questions[position].sentence
        }




    }
}