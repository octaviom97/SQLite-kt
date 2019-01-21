package com.example.octav.sqlite_kt

import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.net.PasswordAuthentication

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ingresar.setOnClickListener() {
            val mail = et_correo.text.toString()
            val pass = et_password.text.toString()
            if (mail.isEmpty() == true || pass.isEmpty() == true) {
                Toast.makeText(this, "No has llenado todos los campos :(", Toast.LENGTH_SHORT).show()
            } else {
                val database= UsuarioDBHelper(this)
                if (validarDatos(database, mail,pass)==true) {
                    val i = Intent(this,Bienvenido::class.java)
                    i.putExtra("nomuser",mail)
                    startActivity(i)
                }else {
                    Toast.makeText(this,"Datos erroneos :(" , Toast.LENGTH_SHORT).show()
                }
            }
        }
        btn_registro.setOnClickListener() {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }

    fun validarDatos(helper: UsuarioDBHelper, correo: String, password: String): Boolean {
        val database = helper.readableDatabase
        val args = arrayOf(correo, password)
        val cursor = database.query(EstructuraBase.UsuarioEntrada.TABLE_NAME, null,
                "correo = ? AND password = ?", args, null, null, null)
        if (cursor.count != 0)
            return true
        else {
            return false
        }

    }

}

