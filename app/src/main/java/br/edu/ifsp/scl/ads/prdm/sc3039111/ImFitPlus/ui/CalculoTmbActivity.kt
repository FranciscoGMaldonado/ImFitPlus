package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.TmbTelaBinding

class CalculoTmbActivity : AppCompatActivity() {

    private lateinit var binding: TmbTelaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TmbTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra("nome")
        val imc = intent.getDoubleExtra("imc", 0.0)
        val categoria = intent.getStringExtra("categoria")
        val peso = intent.getDoubleExtra("peso", 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)
        val idade = intent.getIntExtra("idade", 0)
        val atividade = intent.getStringExtra("atividade") ?: "Moderado"
        val sexo = intent.getStringExtra("sexo")
        val userId = intent.getIntExtra("user", 0)

        val tmb = if(sexo == "Masculino") {
            66 + (13.7 * peso) + (5 * altura * 100) - (6.8 * idade)
        } else {
            655 + (9.6 * peso) + (1.8 * altura * 100) - (4.7 * idade)
        }

        val fator = when (atividade.lowercase()) {
            "sedentário" -> 1.2
            "leve" -> 1.375
            "moderado" -> 1.55
            "intenso" -> 1.725
            else -> 1.2
        }

        val gastoCalorico = tmb * fator

        binding.viewGasto.text = "%.2f".format(gastoCalorico)

        binding.btnPesoIdeal.setOnClickListener {
            val intent = Intent(this, PesoIdealActivity::class.java)
            intent.putExtra("peso", peso)
            intent.putExtra("altura", altura)
            intent.putExtra("gasto", gastoCalorico)
            intent.putExtra("nome", nome)
            intent.putExtra("categoria", categoria)
            intent.putExtra("imc", imc)
            intent.putExtra("user", userId)
            startActivity(intent)
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}