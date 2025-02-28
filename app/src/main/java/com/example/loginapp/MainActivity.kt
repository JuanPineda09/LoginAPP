package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener{
            val nextLogin = Intent(this, LoginActivity::class.java)
            startActivity(nextLogin)
        }
        val btnRegister = findViewById<Button>(R.id.btnRegistro)

        btnRegister.setOnClickListener{
            val nextRegister = Intent(this, RegisterActivity::class.java)
            startActivity(nextRegister)
        }
    }
}