package com.example.practica02kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var txtPeso: EditText
    private lateinit var txtAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button
    private lateinit var lblResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)

        lblResultado = findViewById(R.id.lblResultado)

        // Boton para mandar a llamar la función de calcularIMC
        btnCalcular.setOnClickListener {
            if (txtAltura.text.toString().isEmpty()) {
                // Falta capturar la altura
                Toast.makeText(this@MainActivity, "Favor de llenar los campos", Toast.LENGTH_SHORT)
                    .show()
            } else if (txtPeso.text.toString().isEmpty()) {
                // Falta capturar el peso
                Toast.makeText(this@MainActivity, "Favor de llenar los campos", Toast.LENGTH_SHORT)
                    .show()
            } else {
                calcularIMC()
            }
        }

        // Boton de limpiar
        btnLimpiar.setOnClickListener {
            txtPeso.setText("")
            txtAltura.setText("")
            lblResultado.setText("")
        }

        // Boton para cerrar la app
        btnCerrar.setOnClickListener {
            finish()
        }
    }

    private fun calcularIMC() {
        val peso = txtPeso.text.toString().toDouble()
        val altura = txtAltura.text.toString().toDouble()

        val imc = peso / (altura * altura)

        lblResultado.text = "Tu IMC es: %.2f".format(imc)
    }
}