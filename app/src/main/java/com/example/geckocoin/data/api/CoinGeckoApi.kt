package com.example.geckocoin.data.api

import com.example.geckocoin.data.dto.ExchangesDetailsDto
import com.example.geckocoin.core.Constants.EXCHANGES_DETAILS_ENDPOINT
import com.example.geckocoin.core.Constants.EXCHANGES_ENDPOINT
import com.example.geckocoin.data.dto.ExchangesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinGeckoApi {
    @GET(EXCHANGES_ENDPOINT)
    suspend fun getExchanges():List<ExchangesDto>

    @GET(EXCHANGES_DETAILS_ENDPOINT)
    suspend fun getExchangesDetails(@Path("id") id: String): ExchangesDetailsDto
}