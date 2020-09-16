package br.com.relirk.lembretedecompras.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.relirk.lembretedecompras.models.RequestState
import br.com.relirk.lembretedecompras.models.Usuario
import br.com.relirk.lembretedecompras.repository.UsuarioRepository

class LoginViewModel : ViewModel() {


    private val usuarioRepository = UsuarioRepository()

    val loginState = MutableLiveData<RequestState<Boolean>>()

    fun logar(usuario: Usuario) {
        loginState.value = usuarioRepository.logar(usuario).value
    }


}