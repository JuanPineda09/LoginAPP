package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginapp.MainActivity

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)

        val btnBackHome : ImageView = findViewById(R.id.backHome);

        btnBackHome.setOnClickListener{
            val nextHome = Intent(this, MainActivity::class.java)
            startActivity(nextHome);
        }

        val txtCorreo : EditText = findViewById(R.id.txtCorreo);
        val txtContraseña : EditText = findViewById(R.id.txtContraseña);
        val btnIngreso : Button = findViewById(R.id.btnIngreso);

        val recibirDatos: Bundle? = intent.extras
        val correoGuardado: String? = recibirDatos?.getString("correo")
        val contraseñaGuardada: String? = recibirDatos?.getString("contraseña")
        val nombreGuardado: String? = recibirDatos?.getString("nombre")
        val usuarioGuardado: String? = recibirDatos?.getString("usuario")
        val fechaNacimientoGuardado: String? = recibirDatos?.getString("fechaNacimiento")




        btnIngreso.setOnClickListener{
            val correo = txtCorreo.text.toString()
            val contraseña = txtContraseña.text.toString()

            if (correo == correoGuardado && contraseña == contraseñaGuardada){
                val enviarDataLogin = Bundle()
                enviarDataLogin.putString("nombre", nombreGuardado)
                enviarDataLogin.putString("usuario", usuarioGuardado)
                enviarDataLogin.putString("correo", correoGuardado)
                enviarDataLogin.putString("fechaNacimiento", fechaNacimientoGuardado)

                val nextSuccesLogin = Intent(this, ExitoLoginActivity::class.java)
                nextSuccesLogin.putExtras(enviarDataLogin)
                startActivity(nextSuccesLogin)
            }else{
                AlertDialog.Builder(this).apply {
                    setTitle("Advertencia")
                    setMessage("Correo o contraseña incorrectos")
                }.show()
            }
        }


    }
}