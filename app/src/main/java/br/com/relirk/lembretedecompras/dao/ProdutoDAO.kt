package br.com.relirk.lembretedecompras.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.relirk.lembretedecompras.models.Produto

@Dao
interface ProdutoDao {
    @Query("SELECT * from tabela_produto ORDER BY nome_produto ASC")
    fun getListaDeProdutos(): LiveData<List<Produto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(produto: Produto)

    @Query("DELETE FROM tabela_produto")
    suspend fun deleteAll()
}