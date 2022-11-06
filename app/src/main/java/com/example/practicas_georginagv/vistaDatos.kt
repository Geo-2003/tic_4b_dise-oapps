package com.example.practicas_georginagv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class vistaDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_datos)

        val salir=findViewById<Button>(R.id.btnsalir)
        val enviar=findViewById<Button>(R.id.btnenviar)
        val nom=findViewById<EditText>(R.id.txtnombre)
        val direc=findViewById<EditText>(R.id.txtdireccion)
        val tel=findViewById<EditText>(R.id.txttel)
        val correo=findViewById<EditText>(R.id.txtcorreo)
        val fecha=findViewById<EditText>(R.id.txtfechaN)
        val genero=findViewById<RadioGroup>(R.id.radioGroup)
        //val generof=findViewById<RadioButton>(R.id.rmasculino)

        enviar.setOnClickListener {
            val irdatos= Intent( this,EnviarDatos::class.java)
            irdatos.putExtra("nom",nom.text.toString())
            irdatos.putExtra("direc",direc.text.toString())
            irdatos.putExtra("tel",tel.text.toString())
            irdatos.putExtra("correo",correo.text.toString())
            irdatos.putExtra("fecha",fecha.text.toString())
            irdatos.putExtra("genero",genero.checkedRadioButtonId)
            //irdatos.putExtra("generof",generof.text.toString())
            startActivity(irdatos)
        }
        salir.setOnClickListener {
            finish()
        }
    }
}