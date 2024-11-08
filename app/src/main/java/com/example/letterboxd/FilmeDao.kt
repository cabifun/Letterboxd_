package com.example.letterboxd

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FilmeDao {
    @Query("SELECT * FROM filme_table")
    fun getAllFilmes(): LiveData<List<Filme>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(filme: Filme)

    @Delete
    suspend fun delete(filme: Filme)
}
