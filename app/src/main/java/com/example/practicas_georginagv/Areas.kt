package com.example.practicas_georginagv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class Areas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_areas)

        val valo1=findViewById<EditText>(R.id.valor1)
        val valo2=findViewById<EditText>(R.id.valor2 )
        val res=findViewById<TextView>(R.id.mens)
        val AOpera=findViewById<Button>(R.id.btnA)
        val cuadrado=findViewById<RadioButton>(R.id.cuadrado)
        val triangulo=findViewById<RadioButton>(R.id.triangulo)
        val rectangulo=findViewById<RadioButton>(R.id.rectangulo)
        val rombo=findViewById<RadioButton>(R.id.rombo)
        val pentagono=findViewById<RadioButton>(R.id.pentagono)

        AOpera.setOnClickListener {
            if(cuadrado.isChecked)
                res.text="${valo1.text.toString().toInt()*valo2.text.toString().toInt()}"
            if(triangulo.isChecked)
                res.text="${valo1.text.toString().toInt()*valo2.text.toString().toInt()/2}"
            if(rectangulo.isChecked)
                res.text="${valo1.text.toString().toInt()*valo2.text.toString().toInt()}"
            if(rombo.isChecked)
                res.text="${valo1.text.toString().toInt()*valo2.text.toString().toInt()/2}"
            if(pentagono.isChecked)
                res.text="${valo1.text.toString().toInt()*valo2.text.toString().toInt()/2}"
        }
    }
}