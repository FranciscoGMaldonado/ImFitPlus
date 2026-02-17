package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.PesoTelaBinding

class PesoIdealActivity : AppCompatActivity(){

    private lateinit var binding : PesoTelaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PesoTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra("nome")
        val imc = intent.getDoubleExtra("imc", 0.0)
        val categoria = intent.getStringExtra("categoria")
        val gasto = intent.getDoubleExtra("gasto", 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)
        val idade = intent.getIntExtra("idade", 0)
        val peso = intent.getDoubleExtra("peso", 0.0)
        val pesoIdeal = 22 * (altura * altura)
        val userId = intent.getIntExtra("user", 0)
        val diferenca = if (pesoIdeal > peso){
            pesoIdeal - peso
        } else {
            peso - pesoIdeal
        }

        val diferencaFormat = String.format("%.2f", diferenca)
        binding.viewPesoIdeal.text = "%.2f".format(pesoIdeal)
        binding.viewDiferenca.text = "A Diferença do Peso atual e do Ideal é de $diferencaFormat Kg"

        binding.btnResumo.setOnClickListener {
            val intent = Intent(this, ResumoSaudeActivity::class.java)
            intent.putExtra("pesoIdeal", pesoIdeal)
            intent.putExtra("peso", peso)
            intent.putExtra("idade", idade)
            intent.putExtra("gasto", gasto)
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