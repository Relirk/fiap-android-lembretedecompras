package br.com.relirk.lembretedecompras.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.relirk.lembretedecompras.models.RequestState
import br.com.relirk.lembretedecompras.models.Usuario
import br.com.relirk.lembretedecompras.repository.UsuarioRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val usuarioRepository = UsuarioRepository(application)

    val loginState = MutableLiveData<RequestState<String>>()

    val usuarioLogadoState = MutableLiveData<RequestState<String>>()

    fun getUsuarioLogado() {
        usuarioLogadoState.value = usuarioRepository.getUsuarioLogado().value
    }

    fun doLogin(usuario: Usuario) {
        loginState.value = usuarioRepository.logar(usuario).value
    }

}