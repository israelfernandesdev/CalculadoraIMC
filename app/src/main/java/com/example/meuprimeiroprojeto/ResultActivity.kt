package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f) {
            "Seu IMC é considerado como magro"
        } else if (result in 18.5f..24.9f) {
            "Seu ICM é considerado como normal"
        } else if (result in 25f..29.9f) {
            "Seu IMC é considerado como sobrepeso"
        } else if (result in 30f..39.9f) {
            "Seu IMC é considerado como obeso"
        } else {
            "Seu IMC é considerado como obesidade grave"
        }
        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}