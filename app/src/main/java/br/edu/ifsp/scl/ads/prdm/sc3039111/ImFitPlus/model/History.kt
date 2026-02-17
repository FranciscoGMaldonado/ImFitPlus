package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class History(
    var id: Int? = -1,
    val userId: Int = -1,
    val imc: Double = -1.0,
    val categoria: String = "",
    val gasto: Double = -1.0,
    val pesoIdeal: Double = -1.0,
    var aguaConsumo: Double = -1.0,
    var frequencia: Int = -1
): Parcelable
