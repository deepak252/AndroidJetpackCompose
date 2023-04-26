package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewUserList()
        }
    }
}

var  users : MutableList<User> = mutableListOf(
    User(R.drawable.baseline_person_24,"User 1","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 2","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 3","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 4","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 5","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 6","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 7","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 8","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 9","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 10","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 11","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 12","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 13","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 14","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 15","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 16","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 17","user@gmail.com"),
    User(R.drawable.baseline_person_24,"User 18","user@gmail.com"),
)


@Preview
@Composable
fun PreviewUserList(){
    LazyColumn(content = {
        items(users){
            UserTile(user = it)
        }
    })
//    Column(
//        modifier = Modifier.verticalScroll(rememberScrollState())
//    ){
//        users.map {
//            UserTile(user = it)
//        }
//    }
}


@Composable
fun UserTile(user : User){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            CircularImage(
                user.img,
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.weight(.9f)
            ) {
                Text(
                    user.title,
//                    fontWeight = FontWeight.Bold
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    user.subtitle,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}


@Composable
fun CircularImage(img : Int, modifier: Modifier=Modifier){
    Image(
        painter = painterResource(id = img),
        contentDescription = "Circular Image",
        modifier = modifier
            .size(60.dp)
            .padding(6.dp)
            .clip(CircleShape)
            .background(Color.Gray)
            .padding(8.dp)
        ,
        contentScale = ContentScale.Fit

    )
}

//@Preview(name = "User Tile", showBackground = true, )
//@Composable
//fun PreviewUserTile(){
//    UserTile(
//        R.drawable.baseline_person_24,
//        "User 1",
//        "user@gmail.com"
//    )
//}


data class User(
    val img : Int,
    val title : String,
    val subtitle : String
)