package com.example.letterboxd

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LetterboxdApp(viewModel: FilmeViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "listaFilmes") {
        composable("listaFilmes") {
            ListaFilmesScreen(
                viewModel = viewModel,
                onFilmeClick = { filme ->
                    navController.navigate("detalhesFilme/${filme.id}")
                },
                onAddClick = { navController.navigate("adicionarFilme") }
            )
        }
        composable("detalhesFilme/{filmeId}") { backStackEntry ->
            val filmeId = backStackEntry.arguments?.getString("filmeId")?.toIntOrNull()
            filmeId?.let {
                val filme = viewModel.getFilmeById(it)
                filme?.let { DetalhesFilmeScreen(filme) }
            }
        }
        composable("adicionarFilme") {
            AdicionarFilmeScreen(viewModel) {
                navController.popBackStack()
            }
        }
    }
}
