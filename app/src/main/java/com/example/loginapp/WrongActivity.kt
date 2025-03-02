package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WrongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.wrong)

        var btnSalirApp : Button = findViewById(R.id.btnSalirApp);
        btnSalirApp.setOnClickListener{
            finishAffinity();
        }

        var btnNextWrong : ImageView = findViewById(R.id.backHome);
        btnNextWrong.setOnClickListener{
            val nextWrong = Intent(this, ExitoLoginActivity::class.java)
            startActivity(nextWrong)
        }
    }
}