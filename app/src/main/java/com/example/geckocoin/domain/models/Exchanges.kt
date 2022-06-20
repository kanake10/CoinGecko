package com.example.geckocoin.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exchanges(
    val country: String?,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val image: String,
    val name: String,
)
