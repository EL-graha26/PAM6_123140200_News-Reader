package com.example.newsfeedsimulator.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.compose.AsyncImage
import com.example.newsfeedsimulator.data.model.Article
import com.example.newsfeedsimulator.data.repository.BookmarkRepository

data class NewsDetailScreen(val article: Article) : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()
        
        // Observe bookmark status for this specific article
        val bookmarkedArticles by BookmarkRepository.bookmarkedArticles.collectAsState()
        val isBookmarked = bookmarkedArticles.any { it.url == article.url }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = { 
                            if (isBookmarked) {
                                BookmarkRepository.removeBookmark(article)
                            } else {
                                BookmarkRepository.addBookmark(article)
                            }
                        }) {
                            val icon = if (isBookmarked) Icons.Outlined.Bookmark else Icons.Outlined.BookmarkBorder
                            val color = if (isBookmarked) MaterialTheme.colorScheme.primary else LocalContentColor.current
                            Icon(icon, contentDescription = "Bookmark", tint = color)
                        }
                        IconButton(onClick = { /* TODO Share */ }) {
                            Icon(Icons.Outlined.Share, contentDescription = "Share")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(scrollState)
            ) {
                if (article.urlToImage != null) {
                    AsyncImage(
                        model = article.urlToImage,
                        contentDescription = article.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    )
                }
                
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(
                        text = "TECHNOLOGY", // Placeholder category
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = article.title ?: "Tanpa Judul",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = article.publishedAt ?: "",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "5 min read",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = article.description ?: "Isi berita tidak tersedia dari API.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    
                    Spacer(modifier = Modifier.height(32.dp))
                    
                    val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
                    Button(
                        onClick = { 
                            article.url?.let { url ->
                                uriHandler.openUri(url)
                            }
                        },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text("Baca Selengkapnya di Website", fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}
