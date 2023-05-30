package com.example.jetpackcomposeapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    return Scaffold() { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = homeViewModel.token,
                    style = MaterialTheme.typography.headlineLarge
                )
                // Method 2 : Using Flow.collectAsState
//                Text(
//                    text = homeViewModel.getToken().collectAsState("Initial Value").value,
//                    style = MaterialTheme.typography.headlineLarge
//                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        val rnd = (1000..10000).random()
                        homeViewModel.updateToken("$rnd")
                    }
                ) {
                    Text(text = "Set Token")
                }
            }
        }

    }
}