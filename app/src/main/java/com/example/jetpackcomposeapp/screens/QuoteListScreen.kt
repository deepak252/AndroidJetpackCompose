package com.example.jetpackcomposeapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeapp.R
import com.example.jetpackcomposeapp.controller.QuoteController
import com.example.jetpackcomposeapp.models.Quote
import com.example.jetpackcomposeapp.widgets.QuoteListItem

@Composable
fun QuoteListScreen(quotes : Array<Quote>) {
    Column {
        Text(
            text = "Quotes",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(
                Font(R.font.poppins)
            ),
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(12.dp)
        )
        LazyColumn(content = {
            items(quotes) {
                QuoteListItem(quote = it) {
                    quote->QuoteController.selectedQuote.value=quote
                }
            }
        })
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewQuoteListScreen(){
    QuoteListScreen(emptyArray())
}