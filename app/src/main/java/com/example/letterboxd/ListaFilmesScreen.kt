package com.example.letterboxd

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListaFilmesScreen(
    viewModel: FilmeViewModel,
    onFilmeClick: (Filme) -> Unit,
    onAddClick: () -> Unit
) {
    val filmes by viewModel.todosFilmes.observeAsState(emptyList())
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar Filme")
            }
        }
    ) { contentPadding ->
        LazyColumn(
            contentPadding = contentPadding
        ) {
            items(filmes) { filme ->
                FilmeItem(filme = filme, onClick = { onFilmeClick(filme) })
            }
        }
    }
}

@Composable
fun FilmeItem(filme: Filme, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(text = filme.titulo, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "Ano: ${filme.ano}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "Gênero: ${filme.genero}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "Avaliação: ${filme.avaliacao}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

