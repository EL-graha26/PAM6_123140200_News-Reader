package com.example.newsfeedsimulator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.newsfeedsimulator.presentation.ui.NewsScreen
import com.example.newsfeedsimulator.presentation.viewmodel.NewsViewModel
import com.example.newsfeedsimulator.presentation.theme.NusaNewsTheme

import cafe.adriel.voyager.navigator.Navigator

import cafe.adriel.voyager.transitions.SlideTransition

@Composable
fun App() {
    NusaNewsTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Navigator(com.example.newsfeedsimulator.presentation.ui.MainScreen()) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}