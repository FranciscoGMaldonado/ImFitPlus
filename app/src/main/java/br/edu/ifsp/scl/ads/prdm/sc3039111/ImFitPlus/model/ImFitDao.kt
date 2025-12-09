package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ImFitDao {
    @Insert
    fun insertUser(user: User): Long
    @Query("SELECT * FROM User WHERE id = :id")
    fun getUserById(id: Int): User?
}