package com.example.geckocoin.data.dto

data class ExchangesDetailsDto(
    val alert_notice: String,
    val centralized: Boolean,
    val country: String,
    val description: String?,
    val facebook_url: String,
    val has_trading_incentive: Boolean,
    val image: String,
    val name: String,
    val other_url_1: String,
    val other_url_2: String,
    val public_notice: String,
    val reddit_url: String,
    val slack_url: String,
    val status_updates: List<StatusUpdate>,
    val telegram_url: String,
    val tickers: List<Ticker>,
    val trade_volume_24h_btc: Double,
    val trade_volume_24h_btc_normalized: Double,
    val trust_score: Int,
    val trust_score_rank: Int,
    val twitter_handle: String,
    val url: String,
    val year_established: Int
)