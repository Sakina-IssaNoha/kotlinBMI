package com.example.helloworld

import android.icu.number.NumberFormatter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BmiCalculatorActivity : AppCompatActivity() {
    lateinit var btnCalculate: Button
    lateinit var etWeight: EditText
    lateinit var etHeight: EditText
    lateinit var tvResults: TextView
    lateinit var tvDisplay: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)
        btnCalculate = findViewById(R.id.btnCalculate)
        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvResults = findViewById(R.id.tvResults)
        tvDisplay = findViewById(R.id.tvDisplay)



        btnCalculate.setOnClickListener {
            var weight = etWeight.text.toString()
            var height = etHeight.text.toString()
            if (weight.isBlank()){
                etWeight.error= "Weight is required"
                return@setOnClickListener
            }
            if (height.isBlank()){
                etHeight.error= "Height is required"
                return@setOnClickListener

        }
            calculateBmi(weight.toDouble(),height.toInt())

    }
    }
    fun calculateBmi(weight: Double,height: Int) {
        var heightMeters = height / 100.0
        var display = weight / (heightMeters * heightMeters)
        tvResults.text = display.toString()
        displayinput(display)
    }
        fun displayinput(display:Double){
        if (display < 18.5){
            tvDisplay.text ="Under weight"

        }
        else if(display >= 18.6 && display <=25.0){
            tvDisplay.text ="Normal"
        }
        else if( display > 25.1 && display <=30.0){
            tvDisplay.text ="Overweight"

        }
        else{
        tvDisplay.text = "Obese"
        }
    }
}
