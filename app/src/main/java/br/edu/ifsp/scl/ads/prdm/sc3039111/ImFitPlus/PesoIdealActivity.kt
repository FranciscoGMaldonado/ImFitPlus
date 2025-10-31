package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.PesoTelaBinding

class PesoIdealActivity : AppCompatActivity(){

    private lateinit var binding : PesoTelaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PesoTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val altura = intent.getDoubleExtra("altura", 0.0)
        val peso = intent.getDoubleExtra("peso", 0.0)
        val pesoIdeal = 22 * (altura * altura)
        val diferenca = if (pesoIdeal > peso){
            pesoIdeal - peso
        } else {
            peso - pesoIdeal
        }

        val diferencaFormat = String.format("%.2f", diferenca)
        binding.viewPesoIdeal.text = "%.2f".format(pesoIdeal)
        binding.viewDiferenca.text = "A Diferença do Peso atual e do Ideal é de $diferencaFormat Kg"

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}