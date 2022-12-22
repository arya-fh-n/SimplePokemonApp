package com.arfdevs.compose.simplepokeapp.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arfdevs.compose.simplepokeapp.model.Pokemon
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arfdevs.compose.simplepokeapp.di.Injection
import com.arfdevs.compose.simplepokeapp.model.PokemonDataSource.dummyPokemonData
import com.arfdevs.compose.simplepokeapp.ui.ViewModelFactory
import com.arfdevs.compose.simplepokeapp.ui.common.UiState
import com.arfdevs.compose.simplepokeapp.ui.component.PokemonItem
import com.arfdevs.compose.simplepokeapp.ui.theme.SimplePokeAppTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Int) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value
        .let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getAllPokemons()
                }
                is UiState.Success -> {
                    PokemonList(
                        pokemonList = uiState.data,
                        modifier = modifier,
                        navigateToDetail = navigateToDetail,
                    )
                }
                is UiState.Error -> {}
            }
        }
}

@Composable
fun PokemonList(
    pokemonList: List<Pokemon>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = modifier.padding(start = 4.dp, end = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(pokemonList, key = { it.id }) { data ->
            PokemonItem(
                id = data.id,
                image = data.image,
                name = data.name,
                type = data.type,
                modifier = modifier.clickable {
                    navigateToDetail(data.id)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonListPreview() {
    SimplePokeAppTheme {
        PokemonList(pokemonList = dummyPokemonData, navigateToDetail = {})
    }
}