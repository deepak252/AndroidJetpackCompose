package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeapp.screens.EffectScreen
import com.example.jetpackcomposeapp.screens.RememberCoroutineScope
import com.example.jetpackcomposeapp.screens.RememberUpdatedState
import com.example.jetpackcomposeapp.screens.RememberUpdatedState2
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            EffectScreen()
//            RememberCoroutineScope()
//            RememberUpdatedState()
            RememberUpdatedState2()
        }
    }
}
