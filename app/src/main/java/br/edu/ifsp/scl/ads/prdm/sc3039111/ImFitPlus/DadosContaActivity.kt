package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.DadosContaBinding

class DadosContaActivity : AppCompatActivity(){

    private lateinit var binding: DadosContaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DadosContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener{

            val insertNome = binding.insertNome.text.toString()
            val insertIdade = binding.insertIdade.text.toString().toIntOrNull()
            val insertAltura = binding.insertAltura.text.toString().toDouble()
            val insertPeso = binding.insertPeso.text.toString().toDouble()
            val idSelecionado = binding.insertSexo.checkedRadioButtonId
            val radioSelecionado = findViewById<RadioButton>(idSelecionado)
            val sexo = radioSelecionado.text.toString()

            val imc = insertPeso / (insertAltura * insertAltura)

            val intent = Intent(this, CalculoImcActivity::class.java)
            intent.putExtra("nome", insertNome)
            intent.putExtra("imc", imc)
            intent.putExtra("sexo", sexo)
            intent.putExtra("idade", insertIdade)
            startActivity(intent)
        }
    }
}