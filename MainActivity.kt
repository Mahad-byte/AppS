package com.example.unitconverter

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import com.example.unitconverter.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    override fun onStart() {
        super.onStart()
        val dropdown1 = mainBinding.dropdown1
        val dropdown2 = mainBinding.dropdown2

        ArrayAdapter.createFromResource(
            this, R.array.units, android.R.layout.simple_spinner_dropdown_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            dropdown1.adapter = it
        }
        ArrayAdapter.createFromResource(
            this, R.array.units, android.R.layout.simple_spinner_dropdown_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            dropdown2.adapter = it
        }


        var result = 0.0  //for display
        mainBinding.button.setOnClickListener {
            val value = mainBinding.value.text.toString()

            if (value.isNotEmpty()) {
                val v = value.toDouble()
                    result =
                        combinations(
                            v,
                            dropdown1.selectedItem.toString(),
                            dropdown2.selectedItem.toString()
                        )


                mainBinding.converted.text = result.toString()
            }
             else {
                Toast.makeText(this, "Pls Enter a number", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun combinations(input: Double, unitFrom: String, unitTo: String): Double{
        val combo = listOf(
            "Meter" to "Meter",
            "Meter" to "Centi-Meter",
            "Meter" to "kilo-Meter",
            "Meter" to "Miles",
            "Centi-Meter" to "Meter",
            "Centi-Meter" to "Centi-Meter",
            "Centi-Meter" to "kilo-Meter",
            "Centi-Meter" to "Miles",
            "Miles" to "Meter",
            "Miles" to "Centi-Meter",
            "Miles" to "kilo-Meter",
            "Miles" to "Miles",
            "Kilo-Meter" to "Meter",
            "Kilo-Meter" to "Centi-Meter",
            "Kilo-Meter" to "Kilo-Meter",
            "Kilo-Meter" to "Miles"
        )
        val values = listOf(
            1.0,
            0.01,
            0.001,
            0.000621371,
            100.0,
            1.0,
            0.00001,
            6.2137e-6,
            1609.34,
            160934.0,
            1.60934,
            1.0,
            10.0,
            20.0,
            30.0,
            40.0
        )

        for(i in combo.indices){
            if(combo[i].first == unitFrom && combo[i].second == unitTo){
                val conversion = values[i]
                val temp = input*conversion
                return temp
            }
        }
        return input
    }
}


//https://developer.android.com/develop/ui/views/components/spinner