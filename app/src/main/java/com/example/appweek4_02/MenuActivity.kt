package com.example.appweek4_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val EXTRA_NAME = ("com.example.appWeek4_02")

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        configureBtLogout()
        showNameUser()
        btLevel1()

    }

    private fun showNameUser(){
        val nickname = intent.getStringExtra(EXTRA_MESS)
        this.findViewById<TextView>(R.id.tvName).apply{
            text = nickname
        }
    }

    private fun configureBtLogout(){
        val btLogout = findViewById<Button>(R.id.btLogout)
        btLogout.setOnClickListener(){
            var intent = Intent(this, LoginActivity::class.java).apply {  }
            startActivity(intent)
        }
    }

    private fun btLevel1(){
        val tvName = findViewById<TextView>(R.id.tvName)
        val name = tvName.text
        val btLevel1 = findViewById<Button>(R.id.btLevel1)
        btLevel1.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
            }
            startActivity(intent)
        }
    }

    private fun btLevel2(){

    }

}