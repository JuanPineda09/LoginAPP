package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WrongActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.wrong)

        var btnSalirApp : AppCompatButton = findViewById(R.id.btnSalirApp);
        btnSalirApp.setOnClickListener{
            finishAffinity();
        }

        var btnNextWrong : AppCompatButton = findViewById(R.id.backHome);
        btnNextWrong.setOnClickListener{
            val nextWrong = Intent(this, ExitoLoginActivity::class.java)
            startActivity(nextWrong)
        }
    }
}