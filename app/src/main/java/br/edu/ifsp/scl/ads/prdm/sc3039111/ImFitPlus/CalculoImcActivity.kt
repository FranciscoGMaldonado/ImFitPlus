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
        val peso = intent.getDoubleExtra("peso", 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)
        val idade = intent.getIntExtra("idade", 0)
        val sexo = intent.getStringExtra("sexo") ?: "Masculino"
        val atividade = intent.getStringExtra("atividade") ?: "Moderado"

        binding.viewNome.text = "$nome"
        binding.viewImc.text = "%.2f".format(imc)

        val categoria = when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 25 -> "Normal"
            imc < 30 -> "Sobrepeso"
            else -> "Obesidade"
        }
        binding.viewCategoria.text = categoria

        binding.btnCalcularGasto.setOnClickListener {
            val intent = Intent(this, CalculoTmbActivity::class.java)
            intent.putExtra("sexo", sexo)
            intent.putExtra("idade", idade)
            intent.putExtra("peso", peso)
            intent.putExtra("altura", altura)
            intent.putExtra("atividade", atividade)
            startActivity(intent)
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}