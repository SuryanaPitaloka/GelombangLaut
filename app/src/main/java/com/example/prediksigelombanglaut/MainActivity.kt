package com.example.prediksigelombanglaut

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var modelHelper: ModelHelper

    // Min dan Max dari Colab
    private val minValue = -99.9f
    private val maxValue = 5.405f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        modelHelper = ModelHelper(this)

        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val et4 = findViewById<EditText>(R.id.et4)
        val et5 = findViewById<EditText>(R.id.et5)

        val btn = findViewById<Button>(R.id.btnPrediksi)
        val hasil = findViewById<TextView>(R.id.tvHasil)

        btn.setOnClickListener {

            if (
                et1.text.isEmpty() ||
                et2.text.isEmpty() ||
                et3.text.isEmpty() ||
                et4.text.isEmpty() ||
                et5.text.isEmpty()
            ) {
                hasil.text = "Lengkapi semua input."
                return@setOnClickListener
            }

            val a = normalize(et1.text.toString().toFloat())
            val b = normalize(et2.text.toString().toFloat())
            val c = normalize(et3.text.toString().toFloat())
            val d = normalize(et4.text.toString().toFloat())
            val e = normalize(et5.text.toString().toFloat())

            val input = arrayOf(
                arrayOf(
                    floatArrayOf(a),
                    floatArrayOf(b),
                    floatArrayOf(c),
                    floatArrayOf(d),
                    floatArrayOf(e)
                )
            )

            val output = modelHelper.predict(input)

            val prediction = denormalize(output)

            hasil.text = String.format(
                "Prediksi : %.3f meter",
                prediction
            )
        }
    }

    private fun normalize(x: Float): Float {
        return (x - minValue) / (maxValue - minValue)
    }

    private fun denormalize(x: Float): Float {
        return x * (maxValue - minValue) + minValue
    }
}