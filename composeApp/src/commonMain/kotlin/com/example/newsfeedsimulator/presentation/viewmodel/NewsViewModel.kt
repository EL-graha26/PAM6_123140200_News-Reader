package com.example.newsfeedsimulator.presentation.viewmodel

import com.example.newsfeedsimulator.data.model.Article
import com.example.newsfeedsimulator.data.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel(
    private val scope: CoroutineScope,
    private val repository: NewsRepository = NewsRepository()
) {
    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Article>>> = _uiState.asStateFlow()

    init {
        fetchNews()
    }

    fun fetchNews() {
        scope.launch {
            _uiState.value = UiState.Loading
            val result = repository.fetchNews()
            result.onSuccess { articles ->
                _uiState.value = UiState.Success(articles)
            }.onFailure { error ->
                _uiState.value = UiState.Error(error.message ?: "Terjadi kesalahan yang tidak diketahui")
            }
        }
    }
}
