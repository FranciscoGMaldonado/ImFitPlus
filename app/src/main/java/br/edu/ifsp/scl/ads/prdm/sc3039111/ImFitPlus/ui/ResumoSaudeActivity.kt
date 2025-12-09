package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.ResumoSaudeBinding

class ResumoSaudeActivity : AppCompatActivity() {

    private lateinit var binding: ResumoSaudeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResumoSaudeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra("nome")
        val imc = intent.getDoubleExtra("imc", 0.0)
        val categoria = intent.getStringExtra("categoria")
        val gasto = intent.getDoubleExtra("gasto", 0.0)
        val pesoIdeal = intent.getDoubleExtra("pesoIdeal", 0.0)
        val peso = intent.getDoubleExtra("peso", 0.0)

        val ingestaoAgua = 0.35 * peso

        binding.nomeResumo.text = nome
        binding.imcResumo.text = "%.2f".format(imc)
        binding.categoriaResumo.text = categoria
        binding.pesoIdealResumo.text = "%.2f".format(pesoIdeal)
        binding.gastoResumo.text = "%.2f".format(gasto)
        binding.aguaResumo.text = "%.2f ml".format(ingestaoAgua)
    }
}