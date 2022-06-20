package com.example.geckocoin.data.mappers

import com.example.geckocoin.data.dto.ExchangesDetailsDto
import com.example.geckocoin.data.dto.ExchangesDto
import com.example.geckocoin.domain.models.Exchanges
import com.example.geckocoin.domain.models.ExchangesDetails

fun ExchangesDto.toExchanges(): Exchanges {
    return Exchanges(
        country = country ?: "",
        id = id,
        image = image,
        name = name,

    )
}

fun ExchangesDetailsDto.toExchangesDetails(): ExchangesDetails {
    return ExchangesDetails(
        twitter_handle = twitter_handle,
        url = url,
        year_established = year_established,
        country = country ?: "",
        image = image,
        name =name,
        description = description ?: ""
    )
}