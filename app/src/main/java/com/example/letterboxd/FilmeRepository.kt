package com.example.letterboxd

import androidx.lifecycle.LiveData

class FilmeRepository(private val filmeDao: FilmeDao) {
    val todosFilmes: LiveData<List<Filme>> = filmeDao.getAllFilmes()

    suspend fun insert(filme: Filme) {
        filmeDao.insert(filme)
    }

    suspend fun delete(filme: Filme) {
        filmeDao.delete(filme)
    }
}
