package com.example.android.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.calculatorapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply() {
            one.setOnClickListener { evaluateExpression("1", clear = true) }

            two.setOnClickListener { evaluateExpression("2", clear = true) }

            three.setOnClickListener { evaluateExpression("3", clear = true) }
            four.setOnClickListener { evaluateExpression("4", clear = true) }

            five.setOnClickListener { evaluateExpression("5", clear = true) }

            six.setOnClickListener { evaluateExpression("6", clear = true) }

            seven.setOnClickListener { evaluateExpression("7", clear = true) }

            eight.setOnClickListener { evaluateExpression("8", clear = true) }

            nine.setOnClickListener { evaluateExpression("9", clear = true) }

            zero.setOnClickListener { evaluateExpression("0", clear = true) }

            addition.setOnClickListener { evaluateExpression("+", clear = true) }

            subtract.setOnClickListener { evaluateExpression("-", clear = true) }

            multiply.setOnClickListener { evaluateExpression("*", clear = true) }

            divide.setOnClickListener { evaluateExpression("/", clear = true) }

            dot.setOnClickListener { evaluateExpression(".", clear = true) }

            cancel.setOnClickListener {
                allDetails.text = ""
                results.text = ""
            }

            equal.setOnClickListener {
                val text = allDetails.text.toString()
                val expression = ExpressionBuilder(text).build()

                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    results.text = longResult.toString()
                } else {
                    results.text = result.toString()
                }
            }

            cancel.setOnClickListener {
                val _Test = allDetails.text.toString()
                if (_Test.isNotEmpty()) {
                    allDetails.text = _Test.drop(1)
                }

                results.text = ""
            }
        }
    }

    fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            binding.results.text = ""
            binding.allDetails.append(string)
        } else {
            binding.allDetails.append(binding.results.text)
            binding.results.append(string)
            binding.allDetails.text = ""
        }
    }
}