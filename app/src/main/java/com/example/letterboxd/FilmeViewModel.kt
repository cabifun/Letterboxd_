package com.example.letterboxd

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FilmeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FilmeRepository
    val todosFilmes: LiveData<List<Filme>>

    init {
        val filmeDao = FilmeDatabase.getDatabase(application).filmeDao()
        repository = FilmeRepository(filmeDao)
        todosFilmes = repository.todosFilmes
    }

    fun adicionarFilme(filme: Filme) {
        viewModelScope.launch {
            repository.insert(filme)
        }
    }

    fun getFilmeById(id: Int): Filme? {
        return todosFilmes.value?.find { it.id == id }
    }
}
