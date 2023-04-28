package com.example.jetpackcomposeapp.widgets

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
import com.example.jetpackcomposeapp.models.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick : (quote : Quote)->Unit) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.padding(8.dp)
            .clickable { onClick(quote) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_format_quote_24),
                contentDescription = "Quote Icon",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.Black),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = quote.text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
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

                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewQuoteListItem(){
    QuoteListItem(Quote("This is quote example", "R. Author")){

    }
}