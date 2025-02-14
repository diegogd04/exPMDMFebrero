package com.example.expmdmfebrero.domain

data class Collection(
    val id: String,
    val name: String,
    val mushrooms: List<Mushroom>,
    val favorite: Boolean
)