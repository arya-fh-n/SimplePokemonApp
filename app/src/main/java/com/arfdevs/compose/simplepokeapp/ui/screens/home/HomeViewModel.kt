package com.arfdevs.compose.simplepokeapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arfdevs.compose.simplepokeapp.data.PokemonRepository
import com.arfdevs.compose.simplepokeapp.model.Pokemon
import com.arfdevs.compose.simplepokeapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: PokemonRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Pokemon>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Pokemon>>> get() = _uiState

    fun getAllPokemons() {
        viewModelScope.launch {
            repository.getPokemons()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { pokemonList ->
                    _uiState.value = UiState.Success(pokemonList)
                }
        }
    }
}