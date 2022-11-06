package com.example.practicas_georginagv

import android.content.Context
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
import java.lang.StringBuilder

class directorio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directorio)

        val nom=findViewById<EditText>(R.id.txtnombre)
        val correo=findViewById<EditText>(R.id.txtcorreo)
        val boton=findViewById<Button>(R.id.btnguardar)
        val Viewdatos=findViewById<TextView>(R.id.datos)
        val edad=24
        var altura=1.6f
        val estatus=true
        val salvar=findViewById<Button>(R.id.btnsalvar)
        val buscar=findViewById<Button>(R.id.btnbuscar)

        //permite el almacenamiento de la clase a nuestro celular
        val preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE)    //permite generar archivo XML para el celular
        nom.setText(preferencias.getString("nombre",""))    //muestra el ultimo registro enviado       /lee
        correo.setText(preferencias.getString("email",""))

        //promar evento del boton
        //boton guardar
        boton.setOnClickListener {
            val editor = preferencias.edit()
            editor.putString(
                "nombre",
                nom.text.toString()
            )      //obtener nombre de texto que esta en la caja     / Crea y almacena
            editor.putString(
                "email",
                correo.text.toString()
            )     //relacionar cadena de texto con el mensaje
            editor.putString("edad", edad.toString())
            editor.putString("estatus", estatus.toString())
            editor.putString("altura", altura.toString())
            editor.commit()     //ejecuta la instruccion
            //nom.setText("")
            //correo.setText("")
            Toast.makeText(this, "Datos almacenados corecctamente", Toast.LENGTH_LONG).show()
            Viewdatos.setText("Nombre: ${nom.text.toString()}\n Correo:${correo.text.toString()}\nEdad:${edad.toString()}\nAltura:${altura.toString()}\nEstatus:${estatus.toString()}")

            //BOTON BUSCAR
            buscar.setOnClickListener {
                val informacion = preferencias.getString("", nom.text.toString())
                if (informacion!= null) {
                    if (informacion.length == 0)    //verifica si la longitud de datos es igual a cero
                    {
                        Toast.makeText(this, "No existe el registro", Toast.LENGTH_LONG).show()     //si es un usuario que no existe manda el mensaje
                    } else {
                        Viewdatos.setText((informacion))
                    }
                } else {
                    Toast.makeText(this, "El campo esta en blanco", Toast.LENGTH_LONG).show()   //si los campos estan vacios manda el mensaje
                }
            }
        }

        //SALVAR TXT
        //crea el archivo y lo muestra en el text View(Viewdatos)
        if (fileList().contains("contactos.txt"))
        {
            try {
                val archivo= InputStreamReader(openFileInput("contactos.txt"))
                val br= BufferedReader(archivo)
                var linea=br.readLine()
                val todo= StringBuilder()
                while (linea!=null){    //todas las lineas seran diferentes a null
                    todo.append(linea+"\n")
                    linea=br.readLine()
                }
                br.close()
                archivo.close()
                Viewdatos.setText(todo)
            }catch (e: IOException){

            }
        }

        //programar boton
        //genera una variable de tipo archivo y genera un contacto de txt
        salvar.setOnClickListener {
            try {
                val archivo= OutputStreamWriter(openFileOutput("contacto.txt", MODE_PRIVATE))
                archivo.write(Viewdatos.text.toString())
                archivo.flush()
                archivo.close()
            }catch (e: IOException){     //atrapa el error y lo muestra

            }
            Toast.makeText(this,"El archivo fue almacenado", Toast.LENGTH_LONG).show()
        }
    }
}