package br.com.relirk.lembretedecompras.repository

import androidx.lifecycle.LiveData
import br.com.relirk.lembretedecompras.dao.ProdutoDao
import br.com.relirk.lembretedecompras.models.Produto

class ProdutoRepository(private val produtoDao: ProdutoDao) {

    val produtos: LiveData<List<Produto>> = produtoDao.getListaDeProdutos()

    suspend fun insert(produto: Produto) {
        produtoDao.insert(produto)
    }
}