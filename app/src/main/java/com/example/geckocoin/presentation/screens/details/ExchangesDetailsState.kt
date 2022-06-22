package com.example.geckocoin.presentation.screens.details

import com.example.geckocoin.domain.models.ExchangesDetails

data class ExchangesDetailsState(
    val isLoading: Boolean = false,
    val exchangesDetails: ExchangesDetails? = null,
    val error: String = ""
)