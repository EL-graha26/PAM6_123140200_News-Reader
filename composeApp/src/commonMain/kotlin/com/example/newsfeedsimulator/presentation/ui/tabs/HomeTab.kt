package com.example.newsfeedsimulator.presentation.ui.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.newsfeedsimulator.presentation.ui.NewsScreen
import com.example.newsfeedsimulator.presentation.viewmodel.NewsViewModel

object HomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Outlined.Home)
            return remember {
                TabOptions(index = 0u, title = title, icon = icon)
            }
        }

    @Composable
    override fun Content() {
        val scope = rememberCoroutineScope()
        val viewModel = remember { NewsViewModel(scope) }
        NewsScreen(viewModel = viewModel)
    }
}
