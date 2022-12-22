package com.arfdevs.compose.simplepokeapp.data

import com.arfdevs.compose.simplepokeapp.model.Pokemon
import com.arfdevs.compose.simplepokeapp.model.PokemonDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PokemonRepository {
    private val pokemonData = mutableListOf<Pokemon>()

    init {
        if (pokemonData.isEmpty()) {
            PokemonDataSource.dummyPokemonData.forEach {
                pokemonData.add(it)
            }
        }
    }

    fun getPokemons(): Flow<List<Pokemon>> {
        return flowOf(pokemonData)
    }

    fun getPokemonById(pokemonId: Int): Pokemon {
        return pokemonData.first {
            it.id == pokemonId
        }
    }

    companion object {
        @Volatile
        private var instance: PokemonRepository? = null

        fun getInstance(): PokemonRepository =
            instance ?: synchronized(this) {
                PokemonRepository().apply {
                    instance = this
                }
            }
    }
}