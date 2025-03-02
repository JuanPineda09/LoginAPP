package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registro)

        //Aqui se llaman los objetos le a visual del xml
        var inputName: EditText = findViewById(R.id.inputNombre);
        var inputEmail: EditText = findViewById(R.id.inputCorreo);
        var inputUser: EditText = findViewById(R.id.inputUsuario);
        var inputDate: EditText = findViewById(R.id.inputDate);
        var inputPassword: EditText = findViewById(R.id.inputContraseña);
        var inputPassword2: EditText = findViewById(R.id.inputContraseña2);
        var checkboxTerms: CheckBox = findViewById(R.id.checkboxTerms);

        var btnCreateUser: AppCompatButton = findViewById(R.id.btnCreateUser);
        btnCreateUser.setOnClickListener{

            //Se accede a los datos del xml
            var nombre = inputName.text.toString()
            var correo = inputEmail.text.toString();
            var usuario = inputUser.text.toString();
            var fechaNacimiento = inputDate.text.toString();
            var contraseña = inputPassword.text.toString();
            var contraseña2 = inputPassword2.text.toString();
            var checkbox = checkboxTerms.isChecked();



            //Aqui se realizan las respectivas validaciones de la data obtenida
            if ( nombre.isBlank() || usuario.isBlank() || correo.isBlank() || fechaNacimiento.isBlank() || contraseña.isBlank() || contraseña2.isBlank()){
                var alertCamposVacios = AlertDialog.Builder(this).apply {
                    setTitle("Advertencia Exiten Campos Vacios")
                    setMessage("Por favor llene todos los campos")
                }.show()
            }else if(contraseña != contraseña2){
                var alertContraseñas = AlertDialog.Builder(this).apply {
                    setTitle("Advertencia las contraseñas no coinciden")
                    setMessage("Por favor verifique las contraseñas")
                }.show()
                }else if(checkbox == false){
                    var alertCheckbox = AlertDialog.Builder(this).apply {
                        setTitle("Advertencia no acepto los terminos y condiciones")
                        setMessage("Debe aceptar los terminos y condiciones para continuar con el registro")
                    }.show()
                } else{
                    val enviarDataLogin = Bundle()
                    enviarDataLogin.putString("nombre", nombre)
                    enviarDataLogin.putString("usuario", usuario)
                    enviarDataLogin.putString("correo", correo)
                    enviarDataLogin.putString("fechaNacimiento", fechaNacimiento)
                    enviarDataLogin.putString("contraseña", contraseña)

                    val envioLogin = Intent(this, ExitoRegisterActivity::class.java)
                    envioLogin.putExtras(enviarDataLogin)
                    startActivity(envioLogin)

                }
        }
    }
}