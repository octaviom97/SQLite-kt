package com.example.octav.sqlite_kt

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UsuarioDBHelper(context : Context) : SQLiteOpenHelper(context,
        DATABASE_NAME, null, DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(SQL_ENTRIES)
        }
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DELETE_ENTRIES)
        onCreate(db)
    }
    companion object {
        val DATABASE_NAME = "Usuarios.db"
        val DATABASE_VERSION = 1
        private val SQL_ENTRIES = "CREATE TABLE " + EstructuraBase.UsuarioEntrada.TABLE_NAME +
                "( _id INTEGER PRIMARY KEY, " +
                EstructuraBase.UsuarioEntrada.COLUMN_NAME_MAIL + "TEXT UNIQUE" +
                EstructuraBase.UsuarioEntrada.COLUMN_NAME_PSWD + "TEXT )"
        private val DELETE_ENTRIES =
                "DELETE TABLE IF EXISTS "+ EstructuraBase.UsuarioEntrada.TABLE_NAME
    }
}