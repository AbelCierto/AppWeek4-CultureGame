package com.example.appweek4_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

const val EXTRA_MESS = "com.example.appWeek4_02"
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btLoginConfigure()
    }


    private fun btLoginConfigure(){
        val btLogin = findViewById<Button>(R.id.btLogin)
        val etNickname = findViewById<TextView>(R.id.etEmail)
        btLogin.setOnClickListener(){
            if (etNickname.length() < 1) {
                Toast.makeText( this, "Ingresa un nombre", Toast.LENGTH_SHORT).show()
            }
            else{
                sendName()
            }
        }
    }

    private fun sendName(){
        val etName = findViewById<EditText>(R.id.etEmail)
        val name = etName.text.toString()

        var intent = Intent(this, MenuActivity::class.java).apply {
            putExtra(EXTRA_MESS, name)
        }
        startActivity(intent)
    }

}