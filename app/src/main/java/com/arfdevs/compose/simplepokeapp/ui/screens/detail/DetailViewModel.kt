package com.arfdevs.compose.simplepokeapp.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arfdevs.compose.simplepokeapp.data.PokemonRepository
import com.arfdevs.compose.simplepokeapp.model.Pokemon
import com.arfdevs.compose.simplepokeapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: PokemonRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Pokemon>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Pokemon>> get() = _uiState

    fun getPokemonById(pokemonId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getPokemonById(pokemonId))
        }
    }
}