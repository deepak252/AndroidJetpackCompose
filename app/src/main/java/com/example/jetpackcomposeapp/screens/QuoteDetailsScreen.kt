package com.example.jetpackcomposeapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeapp.R
import com.example.jetpackcomposeapp.controller.QuoteController
import com.example.jetpackcomposeapp.models.Quote


@Composable
fun QuoteDetailsScreen(quote : Quote) {
    //On Back Pressed
    BackHandler() {
        QuoteController.selectedQuote.value=null
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFB9B9B9),
                    )
                )
            )

    ){
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier.padding(24.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(12.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_format_quote_24),
                    contentDescription = "Quote Icon",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(180f),
                )
                Text(
                    text = quote.text,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(
                        Font(R.font.poppins)
                    )
                )
                Divider(
                    modifier = Modifier.fillMaxWidth(0.5f)
                        .padding(vertical = 4.dp)
                )
                Text(
                    text = quote.author,
                    fontWeight = FontWeight.Thin,
                    fontSize = 18.sp,

                    )

            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewQuoteDetailsScreen(){
    QuoteDetailsScreen(Quote("This is quote example", "R. Author"))
}