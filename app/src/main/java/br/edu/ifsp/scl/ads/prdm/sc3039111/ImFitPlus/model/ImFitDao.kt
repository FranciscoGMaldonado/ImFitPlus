package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model

interface ImFitDao {
    fun insertUser(user: User): Long
    fun insertHistory(history: History): Long
    fun getUserById(id: Int): User?
    fun getHistoryById(id: Int): History?
    fun getAllHistory(): List<History>
}