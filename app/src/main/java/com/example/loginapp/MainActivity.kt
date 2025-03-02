package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener{
            val nextLogin = Intent(this, LoginActivity::class.java)
            startActivity(nextLogin)
        }
        val btnRegister = findViewById<Button>(R.id.btnRegistro)
        val btnBackHome : ImageView = findViewById(R.id.backApp);

        btnRegister.setOnClickListener{
            val nextRegister = Intent( this, RegisterActivity::class.java)
            startActivity(nextRegister)
        }

        btnBackHome.setOnClickListener{
            finish()
        }
    }
}