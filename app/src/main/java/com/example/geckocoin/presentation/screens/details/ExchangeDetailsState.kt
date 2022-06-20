package com.example.geckocoin.presentation.screens.details

import com.example.geckocoin.domain.models.ExchangesDetails

data class ExchangeDetailsState(
    val isLoading: Boolean = false,
    val data: ExchangesDetails? = null,
    val error: String = ""
)
