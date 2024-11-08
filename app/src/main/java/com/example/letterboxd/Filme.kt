package com.example.letterboxd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "filme_table")
data class Filme(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val ano: Int,
    val genero: String,
    val avaliacao: Float
)
