package com.example.geckocoin.presentation.screens.exchanges

import com.example.geckocoin.domain.models.Exchanges

data class ExchangesState(
    var isLoading:Boolean=false,
    var exchanges:List<Exchanges>?=null,
    var error:String=""
)