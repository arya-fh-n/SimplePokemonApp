package com.arfdevs.compose.simplepokeapp.di

import com.arfdevs.compose.simplepokeapp.data.PokemonRepository

object Injection {
    fun provideRepository(): PokemonRepository {
        return PokemonRepository.getInstance()
    }
}