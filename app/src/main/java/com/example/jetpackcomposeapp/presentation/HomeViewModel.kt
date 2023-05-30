package com.example.jetpackcomposeapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeapp.data.UserPrefsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userPrefsRepository: UserPrefsRepository
) : ViewModel() {
    var token by mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            userPrefsRepository.getToken.collect{
                token = it
            }
        }
    }

    fun updateToken(token : String){
        viewModelScope.launch {
            userPrefsRepository.setToken(token)
        }
    }
    // Method 2
//    fun getToken(): Flow<String> = userPrefsRepository.getToken

}