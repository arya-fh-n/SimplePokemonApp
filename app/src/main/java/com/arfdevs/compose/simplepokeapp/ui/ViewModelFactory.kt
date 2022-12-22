package com.arfdevs.compose.simplepokeapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arfdevs.compose.simplepokeapp.data.PokemonRepository
import com.arfdevs.compose.simplepokeapp.ui.screens.detail.DetailViewModel
import com.arfdevs.compose.simplepokeapp.ui.screens.home.HomeViewModel

class ViewModelFactory(private val repository: PokemonRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}