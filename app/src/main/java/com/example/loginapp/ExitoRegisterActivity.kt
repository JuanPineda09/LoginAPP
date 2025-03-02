package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExitoRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.exitoregistro)

        var btnBackHome : ImageView = findViewById(R.id.backHome);

        val recibirDatos: Bundle? = intent.extras
        val correoGuardado: String? = recibirDatos?.getString("correo")
        val contraseñaGuardada: String? = recibirDatos?.getString("contraseña")
        val nombreGuardado: String? = recibirDatos?.getString("nombre")
        val usuarioGuardado: String? = recibirDatos?.getString("usuario")
        val fechaNacimientoGuardado: String? = recibirDatos?.getString("fechaNacimiento")

        btnBackHome.setOnClickListener{
            val enviarDataLogin = Bundle()
            enviarDataLogin.putString("nombre", nombreGuardado)
            enviarDataLogin.putString("usuario", usuarioGuardado)
            enviarDataLogin.putString("correo", correoGuardado)
            enviarDataLogin.putString("fechaNacimiento", fechaNacimientoGuardado)
            enviarDataLogin.putString("contraseña", contraseñaGuardada)
            val nextHome = Intent(this, LoginActivity::class.java)
            nextHome.putExtras(enviarDataLogin)
            startActivity(nextHome);
        }
    }
}