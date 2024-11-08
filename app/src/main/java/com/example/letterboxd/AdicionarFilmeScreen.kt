package com.example.letterboxd

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdicionarFilmeScreen(
    viewModel: FilmeViewModel,
    onSave: () -> Unit
) {
    var titulo by remember { mutableStateOf("") }
    var ano by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var avaliacao by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") })
        TextField(value = ano, onValueChange = { ano = it }, label = { Text("Ano") })
        TextField(value = genero, onValueChange = { genero = it }, label = { Text("Gênero") })
        TextField(value = avaliacao, onValueChange = { avaliacao = it }, label = { Text("Avaliação") })
        Button(onClick = {
            viewModel.adicionarFilme(Filme(
                titulo = titulo,
                ano = ano.toIntOrNull() ?: 0,
                genero = genero,
                avaliacao = avaliacao.toFloatOrNull() ?: 0f
            ))
            onSave()
        }) {
            Text("Salvar Filme")
        }
    }
}
