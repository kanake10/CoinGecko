package com.example.geckocoin.domain.repository


import com.example.geckocoin.data.dto.ExchangesDetailsDto
import com.example.geckocoin.data.dto.ExchangesDto

interface ExchangesRepository {
    suspend fun getExchanges():List<ExchangesDto>
    suspend fun getExchangesDetails(exchangesId : String): ExchangesDetailsDto
}