package com.example.geckocoin.data.dto

data class StatusUpdate(
    val category: String,
    val created_at: String,
    val description: String,
    val pin: Boolean,
    val project: Project,
    val user: String,
    val user_title: String
)