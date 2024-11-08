package com.example.letterboxd

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetalhesFilmeScreen(filme: Filme) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Título: ${filme.titulo}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Ano: ${filme.ano}")
        Text(text = "Gênero: ${filme.genero}")
        Text(text = "Avaliação: ${filme.avaliacao}")
    }
}
