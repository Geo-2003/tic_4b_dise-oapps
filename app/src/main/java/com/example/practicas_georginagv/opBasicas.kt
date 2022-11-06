package com.example.practicas_georginagv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class opBasicas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_op_basicas)

        val num1=findViewById<EditText>(R.id.txtval1)
        val num2=findViewById<EditText>(R.id.txtval2)
        val res=findViewById<TextView>(R.id.txtresultado)
        val op=findViewById<Button>(R.id.btnoperacion)
        val suma=findViewById<RadioButton>(R.id.rsum)
        val resta=findViewById<RadioButton>(R.id.rres)
        val multiplicacion=findViewById<RadioButton>(R.id.rmul)
        val division=findViewById<RadioButton>(R.id.rdiv)

        op.setOnClickListener {
            if(suma.isChecked)
                res.text="${num1.text.toString().toInt()+num2.text.toString().toInt()}"
            if(resta.isChecked)
                res.text="${num1.text.toString().toInt()-num2.text.toString().toInt()}"
            if(multiplicacion.isChecked)
                res.text="${num1.text.toString().toInt()*num2.text.toString().toInt()}"
            if(division.isChecked)
                res.text="${num1.text.toString().toInt()/num2.text.toString().toInt()}"

        }
    }
}