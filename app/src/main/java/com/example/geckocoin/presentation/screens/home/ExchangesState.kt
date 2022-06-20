package com.example.geckocoin.presentation.screens.home

import com.example.geckocoin.domain.models.Exchanges

data class ExchangesState(
    var isLoading:Boolean=false,
    var data:List<Exchanges>?=null,
    var error:String=""
)