package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeapp.controller.QuoteController
import com.example.jetpackcomposeapp.screens.QuoteDetailsScreen
import com.example.jetpackcomposeapp.screens.QuoteListScreen
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load data on IO Thread & access data on Main Thread
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            QuoteController.loadQuoteFromAsset(applicationContext);
        }

        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    Scaffold (){contentPadding->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ){
            if(QuoteController.selectedQuote.value==null){
                if(QuoteController.loading.value){
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }else{
                    QuoteListScreen(quotes = QuoteController.quotes )
                }
            }else{
                QuoteDetailsScreen(quote = QuoteController.selectedQuote.value!!)
            }

        }

    }
}
//
//enum class Pages{
//    QUOTES_LIST,
//    QUOTE_DETAIL
//}
