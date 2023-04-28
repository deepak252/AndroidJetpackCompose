package com.example.jetpackcomposeapp.controller

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.jetpackcomposeapp.models.Quote
import com.google.gson.Gson

object QuoteController {
    var quotes = emptyArray<Quote>()
    //State Objects are Thread Safe
    var loading = mutableStateOf(true)
    var selectedQuote = mutableStateOf<Quote?>(null)

    fun loadQuoteFromAsset(context : Context){
        loading.value=true
        val inputStream = context.assets.open("quotes.json") //open file from assets
        val size  :Int =  inputStream.available() // file size
        val buffer = ByteArray(size) //Define buffer (byte array) of given size
        inputStream.read(buffer) // store input stream in buffer
        inputStream.close() // close inputStream
        // Convert byte array (buffer) into sting format
        val json = String(buffer,Charsets.UTF_8) // as JSON is encoded in UTF_8
        val gson = Gson()

        quotes = gson.fromJson(json,Array<Quote>::class.java)
        loading.value=false
    }
}