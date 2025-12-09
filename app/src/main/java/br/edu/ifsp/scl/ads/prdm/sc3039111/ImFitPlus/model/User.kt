package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int? = -1,
    var nome: String = "",
    var idade: Int = -1,
    var sexo: String = "",
    var altura: Double = -1.0,
    var peso: Double = -1.0,
    var atividade: String = ""
): Parcelable
