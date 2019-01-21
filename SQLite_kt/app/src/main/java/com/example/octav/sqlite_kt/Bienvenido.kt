package com.example.octav.sqlite_kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenido.*

class Bienvenido : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)
        val name = intent.getStringExtra("nomuser")
        nombre.text= name
    }
}
