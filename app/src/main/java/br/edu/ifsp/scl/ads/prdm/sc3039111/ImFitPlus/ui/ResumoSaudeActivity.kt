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
        val idade = intent.getIntExtra("idade", 0)
        val peso = intent.getDoubleExtra("peso", 0.0)
        val userId = intent.getIntExtra("user", 0)

        val ingestaoAgua = 0.35 * peso
        val frequencia = 220 - idade

        val zona50 = frequencia * 0.50
        val zona60 = frequencia * 0.60
        val zona70 = frequencia * 0.70
        val zona80 = frequencia * 0.80
        val zona90 = frequencia * 0.90

        val db = ImfitSqlite(this)

        val history = History(
            userId = userId,
            imc = imc,
            categoria = categoria ?: "",
            gasto = gasto,
            pesoIdeal = pesoIdeal,
            aguaConsumo = ingestaoAgua,
            frequencia = frequencia
        )
        db.insertHistory(history)

        binding.nomeResumo.text = nome
        binding.imcResumo.text = "IMC: %.2f".format(imc)
        binding.categoriaResumo.text = "CATEGORIA: ${categoria}"
        binding.pesoIdealResumo.text = "PESO IDEAL: %.2f kg".format(pesoIdeal)
        binding.gastoResumo.text = "GASTO CALÓRICO: %.2f kcal".format(gasto)
        binding.aguaResumo.text = "CONSUMO E ÁGUA IDEAL: %.2f ml".format(ingestaoAgua)
        binding.frequenciaResumo.text = "FREQUÊNCIA CARDÍACA MÁXIMA: ${frequencia}"
        binding.zonaLeve.text = "ZONA LEVE: ${zona50} - ${zona60}"
        binding.zonaQueima.text = "ZONA QUEIMA DE GORDURA: ${zona60} - ${zona70}"
        binding.zonaAero.text = "ZONA AERÓBICA: ${zona70} - ${zona80}"
        binding.zonaAnae.text = "ZONA ANAERÓBICA: ${zona80} - ${zona90}"

        binding.btnInicioResumo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}