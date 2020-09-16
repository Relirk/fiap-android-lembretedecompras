package br.com.relirk.lembretedecompras.repository

import androidx.lifecycle.MutableLiveData
import br.com.relirk.lembretedecompras.models.RequestState
import br.com.relirk.lembretedecompras.models.Usuario

class UsuarioRepository {


    fun logar(usuario: Usuario) : MutableLiveData<RequestState<Boolean>> {

        val response = MutableLiveData<RequestState<Boolean>>()

        response.value = RequestState.Loading

        if(usuario.email == "usuario@fiap.com.br" &&
            usuario.senha == "123456") {
            response.value = RequestState.Success(true)
        } else {
            response.value = RequestState.Error(Throwable("Usuário ou senha inválido"))
        }

        return response
    }
}
