package com.example.octav.sqlite_kt

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        btn_registroR.setOnClickListener(){
            val base = UsuarioDBHelper(this)
            val exitoso = guardarRegistro(base)
            if(exitoso.toInt() == -1){
                Toast.makeText(this,
                        "Este usuario ya esta registrado :(", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,
                        "Usuario creado correctamente (:", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun guardarRegistro(helper : UsuarioDBHelper): Long{
        val base_sql= helper.writableDatabase
        val cv = ContentValues()
        cv.put(EstructuraBase.UsuarioEntrada.COLUMN_NAME_MAIL, et_correoR.text.toString())
        cv.put(EstructuraBase.UsuarioEntrada.COLUMN_NAME_PSWD, et_passwordR.text.toString())
        return  base_sql.insert(EstructuraBase.UsuarioEntrada.TABLE_NAME, null ,cv)
    }
}
