package com.example.geckocoin.domain.models

data class ExchangesDetails(
    val twitter_handle: String,
    val url: String,
    val year_established: Int,
    val country: String?,
    val image: String,
    val name: String,
    val description: String?,
)
