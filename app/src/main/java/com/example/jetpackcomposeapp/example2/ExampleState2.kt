package com.example.jetpackcomposeapp.example2

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// This Plain State Holder Class only handle  UI related state.
class ExampleState2(
    val scrollState : ScrollState,
    val snackbarState : SnackbarHostState
) {
    var count by mutableStateOf(0)
    val shouldShowSnackbar : Boolean
        get() = count%2==1

    suspend fun showSnackbar(msg : String){
        snackbarState.showSnackbar(msg)
    }
}

@Composable
fun rememberExampleSate2(
    scrollState : ScrollState = rememberScrollState(),
    snackbarState : SnackbarHostState = remember {
        SnackbarHostState()
    }
)= remember {
    ExampleState2(scrollState, snackbarState)
}