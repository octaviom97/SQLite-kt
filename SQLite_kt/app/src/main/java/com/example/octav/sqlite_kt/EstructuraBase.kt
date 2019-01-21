package com.example.octav.sqlite_kt

import android.provider.BaseColumns

class EstructuraBase {
    class UsuarioEntrada : BaseColumns{
        companion object {
            val TABLE_NAME= "usuarios"
            val COLUMN_NAME_MAIL = "correo"
            val COLUMN_NAME_PSWD= "password"
        }
    }
}