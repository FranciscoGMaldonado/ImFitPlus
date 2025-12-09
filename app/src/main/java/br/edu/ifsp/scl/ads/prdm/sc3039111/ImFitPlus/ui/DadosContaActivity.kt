package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.ui

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.ui.CalculoImcActivity
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.DadosContaBinding

class DadosContaActivity : AppCompatActivity(){

    private lateinit var binding: DadosContaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DadosContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener{

            val insertNome = binding.insertNome.text.toString()
            val insertIdadeText = binding.insertIdade.text.toString()
            val insertAlturaText = binding.insertAltura.text.toString()
            val insertPesoText = binding.insertPeso.text.toString()
            val idSelecionado = binding.insertSexo.checkedRadioButtonId
            val atividade = binding.insertAtividade.selectedItem.toString()
            val confirma = binding.checkConfirma.isChecked

            if (insertNome.isBlank()) {
                Toast.makeText(this, "Informe o nome", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (insertIdadeText.isBlank()) {
                Toast.makeText(this, "Informe a idade", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (insertAlturaText.isBlank()) {
                Toast.makeText(this, "Informe a altura", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (insertPesoText.isBlank()) {
                Toast.makeText(this, "Informe o peso", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (idSelecionado == -1) {
                Toast.makeText(this, "Selecione o sexo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!confirma){
                Toast.makeText(this, "Confirme o uso de dados", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val insertIdade = insertIdadeText.toIntOrNull()
            val insertAltura = insertAlturaText.toDoubleOrNull()
            val insertPeso = insertPesoText.toDoubleOrNull()
            val radioSelecionado = findViewById<RadioButton>(idSelecionado)
            val sexo = radioSelecionado.text.toString()

            if (insertIdade == null || insertAltura == null || insertPeso == null) {
                Toast.makeText(this, "Valores inválidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val imc = insertPeso / (insertAltura * insertAltura)

            val intent = Intent(this, CalculoImcActivity::class.java)
            intent.putExtra("nome", insertNome)
            intent.putExtra("imc", imc)
            intent.putExtra("sexo", sexo)
            intent.putExtra("idade", insertIdade)
            intent.putExtra("peso", insertPeso)
            intent.putExtra("altura", insertAltura)
            intent.putExtra("atividade", atividade)
            startActivity(intent)
        }
    }
}