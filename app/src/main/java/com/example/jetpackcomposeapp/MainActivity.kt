package com.example.jetpackcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val initialOffsetX = with(LocalDensity.current) {
                (LocalConfiguration.current.screenWidthDp).dp.toPx().toInt()
            }
            Log.d("MyTag",initialOffsetX.toString())
            Navigation(initialOffsetX = initialOffsetX)
        }
    }
}
