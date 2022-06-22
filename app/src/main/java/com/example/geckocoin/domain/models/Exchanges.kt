package com.example.geckocoin.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Exchanges(
    val country: String?,
    val id: String,
    val image: String,
    val name: String,
)
