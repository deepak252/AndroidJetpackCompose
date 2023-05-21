package com.example.jetpackcomposeapp.example3

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

// Related to Business Logic
class ExampleViewModel3() : ViewModel() {
    var st1 by mutableStateOf("Initial Value")
        private set

    init {
        viewModelScope.launch {
            // Fetch Data
        }
    }
    fun setValue(txt : String){
        st1=txt
    }
}