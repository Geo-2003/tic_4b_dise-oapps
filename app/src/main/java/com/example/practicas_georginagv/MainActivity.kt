package com.example.practicas_georginagv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val opbasicas=findViewById<Button>(R.id.btnopbasicas)
        val opareas=findViewById<Button>(R.id.btnareas)
        val opperimetro=findViewById<Button>(R.id.btnperimetros)

        val opdatos=findViewById<Button>(R.id.btnenviardatos)
        val opdirectorio=findViewById<Button>(R.id.btndirectorio)
        val opagenda=findViewById<Button>(R.id.btnagenda)

        opbasicas.setOnClickListener {
            val opbasicas= Intent(this,opBasicas::class.java)
            startActivity(opbasicas)

        }
        opareas.setOnClickListener {
            val opareas= Intent(this,Areas::class.java)
            startActivity(opareas)
        }

        opdatos.setOnClickListener {
            val datoss= Intent(this,EnviarDatos::class.java)
            startActivity(datoss)
        }

        opdirectorio.setOnClickListener {
            val directorio= Intent(this,directorio::class.java)
            startActivity(directorio)
        }

        opagenda.setOnClickListener {
            val agenda= Intent(this,Agenda::class.java)
            startActivity(agenda)
        }

        opperimetro.setOnClickListener {
            val perimetr= Intent(this,perimetros::class.java)
            startActivity(perimetr)
        }

    }
}