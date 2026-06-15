package com.example.newsfeedsimulator.data.repository

import com.example.newsfeedsimulator.data.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object BookmarkRepository {
    private val _bookmarkedArticles = MutableStateFlow<List<Article>>(emptyList())
    val bookmarkedArticles: StateFlow<List<Article>> = _bookmarkedArticles.asStateFlow()

    fun addBookmark(article: Article) {
        val current = _bookmarkedArticles.value.toMutableList()
        if (!current.any { it.url == article.url }) {
            current.add(article)
            _bookmarkedArticles.value = current
        }
    }

    fun removeBookmark(article: Article) {
        val current = _bookmarkedArticles.value.toMutableList()
        current.removeAll { it.url == article.url }
        _bookmarkedArticles.value = current
    }

    fun isBookmarked(article: Article): Boolean {
        return _bookmarkedArticles.value.any { it.url == article.url }
    }
}
