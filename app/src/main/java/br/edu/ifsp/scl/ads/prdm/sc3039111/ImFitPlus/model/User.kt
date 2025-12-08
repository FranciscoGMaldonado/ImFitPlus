package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    var nome: String,
    var idade: Int,
    var sexo: String,
    var altura: Double,
    var peso: Double,
    var atividade: String
): Parcelable
