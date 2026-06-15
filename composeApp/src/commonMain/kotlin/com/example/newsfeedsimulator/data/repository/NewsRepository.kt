package com.example.newsfeedsimulator.data.repository

import com.example.newsfeedsimulator.data.model.Article
import com.example.newsfeedsimulator.data.model.NewsResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class NewsRepository {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }

    private val apiKey = "aa15f5e1d04c4b11b5b03b471e006222"
    suspend fun fetchNews(): Result<List<Article>> {
        val url = "https://newsapi.org/v2/everything?domains=kompas.com,detik.com,tribunnews.com,cnnindonesia.com,cnbcindonesia.com,liputan6.com&language=id&apiKey=$apiKey"
        return executeRequest(url)
    }

    suspend fun searchNews(query: String): Result<List<Article>> {
        val url = "https://newsapi.org/v2/everything?q=$query&language=id&apiKey=$apiKey"
        return executeRequest(url)
    }

    private suspend fun executeRequest(url: String): Result<List<Article>> {
        return try {
            val response: NewsResponse = client.get(url).body()
            if (response.status == "error") {
                Result.failure(Exception(response.message ?: "Unknown API Error: ${response.code}"))
            } else {
                Result.success(response.articles.filter { it.title != "[Removed]" })
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
