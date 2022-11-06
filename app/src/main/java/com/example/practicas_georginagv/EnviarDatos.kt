package com.example.practicas_georginagv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EnviarDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_datos)

        val bundle=intent.extras
        val nom=bundle?.getString("nom")
        val direccion=bundle?.getString("direc")
        val tel=bundle?.getString("tel")
        val correo=bundle?.getString("correo")
        val fecha=bundle?.getString("fecha")
        //val generom=bundle?.getString("generom")
        //val generof=bu

        val salir=findViewById<Button>(R.id.btnsalir)
        val recibirdatos=findViewById<TextView>(R.id.txtdatos)

        recibirdatos.setText("Nombre: ${nom}\nDireccion:${direccion}\nTelefono:${tel}\nCorreo:${correo}\nFecha de Nacimiento:${fecha}")
        //recibirdatos.setText("direccion:${direccion}")
        salir.setOnClickListener {
            finish();
        }
    }
}