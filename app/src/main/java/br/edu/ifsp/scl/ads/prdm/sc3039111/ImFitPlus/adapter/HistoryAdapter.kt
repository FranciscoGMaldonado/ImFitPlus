package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.databinding.TileHistoryBinding
import br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model.History

class HistoryAdapter(private val historyList: MutableList<History>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    inner class HistoryViewHolder(binding: TileHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
            val idUser = binding.idUser
            val imcTv = binding.imcTv
            val categoriaTv = binding.categoriaTv
            val gastoTv = binding.gastoTv
            val pesoIdealTv = binding.pesoIdealTv
            val aguaTv = binding.aguaTv
            val frequenciaTv = binding.frequenciaTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            TileHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = historyList.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = historyList[position]

        holder.idUser.text = "ID_USUÁRIO: ${item.userId}"
        holder.imcTv.text = "IMC: %.2f".format(item.imc)
        holder.categoriaTv.text = "Categoria: ${item.categoria}"
        holder.gastoTv.text = "Gasto: %.2f kcal".format(item.gasto)
        holder.pesoIdealTv.text = "Peso ideal: %.2f kg".format(item.pesoIdeal)
        holder.aguaTv.text = "Água/dia: %.2f ml".format(item.aguaConsumo)
        holder.frequenciaTv.text = "Freqeuncia: ${item.frequencia}"
    }
}
