package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var spinnerCurrency: Spinner
    private lateinit var spinnerToCurrency: Spinner
    private lateinit var editTextAmount: EditText
    private lateinit var buttonConvert: Button
    private lateinit var buttonReset: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spinnerCurrency = binding.spinnerCurrency
        spinnerToCurrency = binding.spinnerToCurrency
        editTextAmount = binding.editTextAmount
        buttonConvert = binding.buttonConvert
        buttonReset = binding.buttonReset
        textViewResult = binding.textViewResult

        buttonConvert.setOnClickListener {
            convertCurrency()
        }

        buttonReset.setOnClickListener {
            resetFields()
        }

    }

    private fun resetFields() {
        editTextAmount.text.clear()
        textViewResult.text = "0"
    }

    private fun convertCurrency() {
        val selectedCurrency = spinnerCurrency.selectedItem.toString()
        val selectedToCurrency = spinnerToCurrency.selectedItem.toString()
        val amount = editTextAmount.text.toString().toDoubleOrNull()
        var convertedAmount = 0.0

        if(amount != null){
           if(selectedToCurrency == "USD"){
               convertedAmount = when (selectedCurrency) {
                   "EUR" -> amount * 0.84
                   "CLP" -> amount * 1.18
                   "COP" -> amount * 1.38
                   else -> 0.0}
               }else if (selectedToCurrency == "EUR"){

               convertedAmount = when (selectedCurrency) {
                   "USD" -> amount * 1.18
                   "CLP" -> amount * 0.18
                   "COP" -> amount * 2.38
                   else -> 0.0}

            } else if (selectedToCurrency == "CLP"){
               convertedAmount = when (selectedCurrency) {
                   "EUR" -> amount * 0.18
                   "USD" -> amount * 3.18
                   "COP" -> amount * 2.38
                   else -> 0.0}

            } else if (selectedToCurrency == "COP"){
               convertedAmount = when (selectedCurrency) {
                   "EUR" -> amount * 1.18
                   "USD" -> amount * 0.18
                   "CLP" -> amount * 4.38
                   else -> 0.0}
           }
            textViewResult.text = convertedAmount.toString()
    }



}}