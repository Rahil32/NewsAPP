package com.rahil.test3.data

data class NewsAPI(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)