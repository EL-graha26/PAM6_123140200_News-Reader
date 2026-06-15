package com.example.newsfeedsimulator.presentation.ui.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.newsfeedsimulator.data.repository.BookmarkRepository
import com.example.newsfeedsimulator.presentation.ui.LatestNewsCard
import com.example.newsfeedsimulator.presentation.ui.NewsDetailScreen

object BookmarkTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Bookmark"
            val icon = rememberVectorPainter(Icons.Outlined.BookmarkBorder)
            return remember {
                TabOptions(index = 3u, title = title, icon = icon)
            }
        }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val bookmarkedArticles by BookmarkRepository.bookmarkedArticles.collectAsState()

        Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            CenterAlignedTopAppBar(
                title = { Text("Saved Articles", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )

            if (bookmarkedArticles.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        "Belum ada berita yang disimpan.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp)
                ) {
                    items(bookmarkedArticles) { article ->
                        LatestNewsCard(
                            article = article,
                            onClick = { navigator?.parent?.push(NewsDetailScreen(article)) }, // Push to root navigator
                            trailingIcon = {
                                IconButton(
                                    onClick = { BookmarkRepository.removeBookmark(article) },
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Delete,
                                        contentDescription = "Hapus",
                                        tint = MaterialTheme.colorScheme.error,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
