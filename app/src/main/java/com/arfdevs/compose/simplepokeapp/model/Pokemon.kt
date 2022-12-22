package com.arfdevs.compose.simplepokeapp.model

data class Pokemon (
    val id: Int,
    val image: Int,
    val name: String,
    val type: Type,
    val entry: String
)