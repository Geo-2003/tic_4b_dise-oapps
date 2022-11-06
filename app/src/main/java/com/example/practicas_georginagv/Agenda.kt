package com.example.practicas_georginagv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Agenda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val fecha = findViewById<EditText>(R.id.txtdate)
        val hora = findViewById<EditText>(R.id.txttime)
        val datos = findViewById<TextView>(R.id.txtdatos)
        val guardar = findViewById<Button>(R.id.btnguardar)
        val buscar = findViewById<Button>(R.id.btnbuscar)
        val salir = findViewById<Button>(R.id.btnsalir)

        //val salir = findViewById<Button>(R.id.btnsalir)
        //val desplegar = findViewById<Spinner>(R.id.spinner)

        val nombredelarchivo=fecha.text.toString().replace("/","-")+hora.text.toString()
        //GENERAR ARCHIVO DE TEXTO
        guardar.setOnClickListener {
            Toast.makeText(this,"CREADO", Toast.LENGTH_LONG).show()
            try{
                val archivo= OutputStreamWriter(openFileOutput("${nombredelarchivo}.txt",
                    MODE_PRIVATE
                ))
                archivo.write((datos.text.toString()))
                archivo.flush()
                archivo.close()
            }catch (e: IOException){

            }
            Toast.makeText(this, "Los datos fueron almacenados", Toast.LENGTH_LONG).show()
            datos.setText("")
        }

        buscar.setOnClickListener {
            if (fileList().contains(nombredelarchivo+".txt")){
                try {
                    val archivo = InputStreamReader(openFileInput(nombredelarchivo+".txt"))
                    val br = BufferedReader(archivo)
                    var linea = br.readLine()
                    val todo = StringBuilder()
                    while (linea != null) {
                        todo.append(linea + "\n")
                        linea = br.readLine()
                    }
                    br.close()
                    archivo.close()
                    datos.setText(todo)
                    Toast.makeText(this,"No existe archivo con ese nombre", Toast.LENGTH_LONG).show()

                }catch (e: IOException){
                    //almacenar todas las lineas
                    //las lineas las agregue al archivo
                }
            }else{
                Toast.makeText(this,"No existe archivo con ese nombre", Toast.LENGTH_LONG).show()
                datos.setText("")


            }
        }

        salir.setOnClickListener {
            finish()
        }
    }
}