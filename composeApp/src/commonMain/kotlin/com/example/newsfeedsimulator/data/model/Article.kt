package com.example.newsfeedsimulator.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("status") val status: String? = null,
    @SerialName("totalResults") val totalResults: Int = 0,
    @SerialName("articles") val articles: List<Article> = emptyList(),
    @SerialName("code") val code: String? = null,
    @SerialName("message") val message: String? = null
)

@Serializable
data class Article(
    @SerialName("title") val title: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("urlToImage") val urlToImage: String? = null,
    @SerialName("publishedAt") val publishedAt: String? = null,
    @SerialName("content") val content: String? = null
) : PlatformSerializable
