package com.example.jetpackcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

// 3. Guideline, Barrier, Chains
@Composable
fun SecondScreen(){
//    GuidelineExample()
//    BarrierExample()
    ChainExample()
}

@Composable
fun GuidelineExample(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box1, box2, box3)= createRefs()
        val guidelineTop = createGuidelineFromTop(40.dp)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(guidelineTop)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(box3) {
                    top.linkTo(box2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}


@Composable
fun BarrierExample(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box1, box2, box3)= createRefs()
        val barrierEnd = createEndBarrier(
            box1,box2   // Barrier at the end of box1 & box2
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }

        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom)
                    start.linkTo(parent.start)
                }
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(box3) {
                    top.linkTo(box1.bottom)
                    start.linkTo(barrierEnd)
                }

        )
    }
}


@Composable
fun ChainExample(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box1, box2, box3)= createRefs()
        createHorizontalChain(
            box1,box2,box3,
            chainStyle = ChainStyle.SpreadInside
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }

        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    top.linkTo(box1.top)
                    bottom.linkTo(box1.bottom)
                    start.linkTo(box1.end)
                }
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(box3) {
                    top.linkTo(box2.top)
                    bottom.linkTo(box2.bottom)
                    start.linkTo(box2.end)
                    end.linkTo(parent.end)
                }

        )
    }
}