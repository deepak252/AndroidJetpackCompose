package com.example.jetpackcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

// 1. Simple Example
@Composable
fun FirstScreen(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box1, box2, box3)= createRefs()
        Box(
            modifier = Modifier.size(100.dp)
                .background(Color.Red)
                .constrainAs(box1){
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier.size(75.dp)
                .background(Color.Blue)
                .constrainAs(box2){
                    top.linkTo(box1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier.size(50.dp)
                .background(Color.Green)
                .constrainAs(box3){
                    top.linkTo(box2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}