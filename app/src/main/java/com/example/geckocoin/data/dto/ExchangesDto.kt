package com.example.geckocoin.data.dto

data class ExchangesDto(
    val country: String,
    val description: String,
    val has_trading_incentive: Boolean,
    val id: String,
    val image: String,
    val name: String,
    val trade_volume_24h_btc: Double,
    val trade_volume_24h_btc_normalized: Double,
    val trust_score: Int,
    val trust_score_rank: Int,
    val url: String,
    val year_established: Int
)