package com.example.newsfeedsimulator.presentation.viewmodel

import com.example.newsfeedsimulator.data.model.Article
import com.example.newsfeedsimulator.data.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExploreViewModel(private val scope: CoroutineScope) {
    private val repository = NewsRepository()

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Success(emptyList()))
    val uiState: StateFlow<UiState<List<Article>>> = _uiState

    fun searchNews(query: String) {
        if (query.isBlank()) {
            _uiState.value = UiState.Success(emptyList())
            return
        }
        
        _uiState.value = UiState.Loading
        scope.launch {
            val result = repository.searchNews(query)
            result.onSuccess { articles ->
                _uiState.value = UiState.Success(articles)
            }.onFailure { error ->
                _uiState.value = UiState.Error(error.message ?: "Terjadi kesalahan")
            }
        }
    }
}
