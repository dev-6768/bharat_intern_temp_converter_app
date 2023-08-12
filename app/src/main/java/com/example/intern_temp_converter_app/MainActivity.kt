package com.example.intern_temp_converter_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextDegreeC = findViewById<EditText>(R.id.DegreeCelsius)
        val editTextDegreeF = findViewById<EditText>(R.id.DegreeFahrenheit)
        val editTextKelvin = findViewById<EditText>(R.id.Kelvin)

        val actionButton = findViewById<Button>(R.id.actionButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        actionButton.setOnClickListener {
            if(editTextDegreeC.text.toString() != "" && editTextDegreeF.text.toString() == "" && editTextKelvin.text.toString() == "") {
                val number = editTextDegreeC.text.toString().toDouble()
                editTextDegreeF.setText("${(9*number)/5 + 32} degree F")
                editTextKelvin.setText("${number + 273} K")
            }

            else if(editTextDegreeC.text.toString() == "" && editTextDegreeF.text.toString() != "" && editTextKelvin.text.toString() == "") {

                val number = editTextDegreeF.text.toString().toDouble()
                editTextDegreeC.setText("${(5*(number - 32))/9} degree C")
                editTextKelvin.setText("${(5*(number - 32))/9 + 273} K")
            }

            else if(editTextDegreeC.text.toString() == "" && editTextDegreeF.text.toString() == "" && editTextKelvin.text.toString() != "") {
                val number = editTextKelvin.text.toString().toDouble()
                editTextDegreeC.setText("${number-273} degree C")
                editTextDegreeF.setText("${(9*(number - 273))/5 + 32} degree F")
            }

            else{
                Toast.makeText(this, "Please fill up the values properly.", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener{
            editTextDegreeC.setText("")
            editTextDegreeF.setText("")
            editTextKelvin.setText("")
        }

    }
}