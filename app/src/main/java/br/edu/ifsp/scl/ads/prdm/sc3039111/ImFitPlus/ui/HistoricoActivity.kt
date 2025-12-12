package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.adapter.HistoryAdapter
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.HistoricoTelaBinding
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model.History
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model.ImfitSqlite

class HistoricoActivity : AppCompatActivity() {

    private lateinit var binding: HistoricoTelaBinding
    private lateinit var db: ImfitSqlite
    private lateinit var adapter: HistoryAdapter
    private val historyList = mutableListOf<History>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HistoricoTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = ImfitSqlite(this)

        adapter = HistoryAdapter(historyList)
        binding.historyRv.layoutManager = LinearLayoutManager(this)
        binding.historyRv.adapter = adapter

        loadHistory()

        binding.btnInicio.setOnClickListener {
            finish()
        }
    }

    private fun loadHistory() {
        val data = db.getAllHistory()
        historyList.clear()
        historyList.addAll(data)
        adapter.notifyDataSetChanged()
    }
}