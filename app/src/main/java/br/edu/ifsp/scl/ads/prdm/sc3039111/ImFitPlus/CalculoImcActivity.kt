package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.CalculoTelaBinding

class CalculoImcActivity : AppCompatActivity(){

    private lateinit var binding: CalculoTelaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculoTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra("nome")
        val imc = intent.getDoubleExtra("imc", 0.0)

        binding.viewNome.text = "$nome"
        binding.viewImc.text = "$imc"

        val categoria = when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 25 -> "Normal"
            imc < 30 -> "Sobrepeso"
            else -> "Obesidade"
        }
        binding.viewCategoria.text = categoria

        binding.btnCalcularGasto.setOnClickListener {
            val intent = Intent(this, CalculoTmbActivity::class.java)
            startActivity(intent)
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}