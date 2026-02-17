package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var id: Int? = -1,
    var nome: String = "",
    var idade: Int = -1,
    var dataNasc: String = "",
    var sexo: String = "",
    var altura: Double = -1.0,
    var peso: Double = -1.0,
    var atividade: String = ""
): Parcelable
