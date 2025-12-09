package br.edu.ifsp.scl.ads.prdm.sc3039111.ImFitPlus.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class ImfitSqlite(context: Context) : ImFitDao {

    companion object {
        private val FIT_DB = "imfitplus.db"
        private val USER_TABLE = "user"
        private val ID_COLUMN = "id"
        private val COL_NOME = "nome"
        private val COL_IDADE = "idade"
        private val COL_SEXO = "sexo"
        private val COL_ALTURA = "altura"
        private val COL_PESO = "peso"
        private val COL_ATIVIDADE = "atividade"

        val CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS $USER_TABLE ( " +
                "$ID_COLUMN INTEGER NOT NULL PRIMARY KEY, " +
                "$COL_NOME TEXT," +
                "$COL_IDADE INTEGER," +
                "$COL_SEXO TEXT," +
                "$COL_ALTURA REAL," +
                "$COL_PESO REAL," +
                "$COL_ATIVIDADE TEXT);"
    }

    private val fitDb: SQLiteDatabase = context.openOrCreateDatabase(FIT_DB, Context.MODE_PRIVATE, null)

    init {
        fitDb.execSQL(CREATE_USER_TABLE)
    }

    override fun insertUser(user: User) =
        fitDb.insert(USER_TABLE, null, user.toContentValues())

    override fun getUserById(id: Int): User {
        val cursor = fitDb.query(
            USER_TABLE,
            null,
            "$ID_COLUMN = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        return if (cursor.moveToFirst()) {
            cursor.toUser()
        }
        else {
            User()
        }
    }

    private fun User.toContentValues() = ContentValues().apply {
        put(ID_COLUMN, id)
        put(COL_NOME, nome)
        put(COL_IDADE, idade)
        put(COL_SEXO, sexo)
        put(COL_ALTURA, altura)
        put(COL_PESO, peso)
        put(COL_ATIVIDADE, atividade)
    }

    private fun Cursor.toUser() = User(
        getInt(getColumnIndexOrThrow(ID_COLUMN)),
        getString(getColumnIndexOrThrow(COL_NOME)),
        getInt(getColumnIndexOrThrow(COL_IDADE)),
        getString(getColumnIndexOrThrow(COL_SEXO)),
        getDouble(getColumnIndexOrThrow(COL_ALTURA)),
        getDouble(getColumnIndexOrThrow(COL_PESO)),
        getString(getColumnIndexOrThrow(COL_ATIVIDADE))
    )
}
