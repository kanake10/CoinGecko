package com.example.geckocoin.data.repository

import com.example.geckocoin.data.dto.ExchangesDetailsDto
import com.example.geckocoin.data.api.CoinGeckoApi
import com.example.geckocoin.data.dto.ExchangesDto
import com.example.geckocoin.domain.repository.ExchangesRepository
import javax.inject.Inject

class ExchangesRepositoryImpl @Inject constructor(
    private val coinGeckoApi: CoinGeckoApi
) : ExchangesRepository {
    override suspend fun getExchanges(): List<ExchangesDto> {
        return coinGeckoApi.getExchanges()
    }

    override suspend fun getExchangesDetails(id: String): ExchangesDetailsDto {
        return coinGeckoApi.getExchangesDetails(id)
    }


}

