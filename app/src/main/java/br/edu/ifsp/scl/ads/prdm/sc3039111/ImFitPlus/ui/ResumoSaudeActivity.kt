package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.ResumoSaudeBinding
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model.History
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model.ImfitSqlite

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
        val userId = intent.getIntExtra("user", 0)

        val ingestaoAgua = 0.35 * peso

        val db = ImfitSqlite(this)

        val history = History(
            userId = userId,
            imc = imc,
            categoria = categoria ?: "",
            gasto = gasto,
            pesoIdeal = pesoIdeal,
            aguaConsumo = ingestaoAgua
        )
        db.insertHistory(history)

        binding.nomeResumo.text = nome
        binding.imcResumo.text = "%.2f".format(imc)
        binding.categoriaResumo.text = categoria
        binding.pesoIdealResumo.text = "%.2f".format(pesoIdeal)
        binding.gastoResumo.text = "%.2f".format(gasto)
        binding.aguaResumo.text = "%.2f ml".format(ingestaoAgua)

        binding.btnHistorico.setOnClickListener{
            val intent = Intent(this, HistoricoActivity::class.java)
            startActivity(intent)
        }
    }
}