package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExitoLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.exitologin)

        val recibirDatos: Bundle? = intent.extras
        val correoGuardado: String? = recibirDatos?.getString("correo")
        val nombreGuardado: String? = recibirDatos?.getString("nombre")
        val usuarioGuardado: String? = recibirDatos?.getString("usuario")
        val fechaNacimientoGuardado: String? = recibirDatos?.getString("fechaNacimiento")

        val mostrarNombre: TextView = findViewById(R.id.mostrarNombre)
        val mostrarUsuario: TextView = findViewById(R.id.mostrarUsuario)
        val mostrarCorreo: TextView = findViewById(R.id.mostrarCorreo)
        val mostrarDate: TextView = findViewById(R.id.mostrarDate)
        val backHome: ImageView = findViewById(R.id.backHome)

        mostrarNombre.text = "¡Bienvenido ${nombreGuardado}!"
        mostrarUsuario.text = "Usuario: ${usuarioGuardado}"
        mostrarCorreo.text = "Correo: ${correoGuardado}"
        mostrarDate.text = "Fecha de Nacimiento: ${fechaNacimientoGuardado}"


        var btnNextWrong : Button = findViewById(R.id.btnNextWrong);
        btnNextWrong.setOnClickListener {
            val nextWrong = Intent(this, WrongActivity::class.java)
            startActivity(nextWrong)
        }

        backHome.setOnClickListener {
            val backHome = Intent(this, MainActivity::class.java)
            startActivity(backHome)
        }


    }
}