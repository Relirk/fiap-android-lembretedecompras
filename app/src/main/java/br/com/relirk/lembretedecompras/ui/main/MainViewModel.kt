package br.com.relirk.lembretedecompras.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.relirk.lembretedecompras.dao.LembretedeComprasRoomDatabase
import br.com.relirk.lembretedecompras.models.Produto
import br.com.relirk.lembretedecompras.repository.ProdutoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ProdutoRepository

    val produtos: LiveData<List<Produto>>

    init {
        val produtoDao =
            LembretedeComprasRoomDatabase.getDatabase(application).produtoDao()
        repository = ProdutoRepository(produtoDao)
        produtos = repository.produtos
    }

    fun insert(produto: Produto) = viewModelScope.launch(Dispatchers.IO) {

        repository.insert(produto)

    }

}