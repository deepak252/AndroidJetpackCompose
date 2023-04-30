package com.example.jetpackcomposeapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

//2. Using ConstraintSet, Bias (Horizontal , Vertical)
@Composable
fun LoginScreen() {
    val constraints = ConstraintSet {
        val email = createRefFor("email")
        val password = createRefFor("password")
        val  btnLogin = createRefFor("btnLogin")

        constrain(email){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }
        constrain(password){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(email.bottom)
        }
        constrain(btnLogin){
            linkTo(
                parent.start, parent.end
            )
            linkTo(
                password.bottom, parent.bottom,
                bias = 0f
            )
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
//            top.linkTo(password. bottom,)
//            bottom.linkTo(parent.bottom)
        }
    }
    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.layoutId("email")
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.layoutId("password"),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.layoutId("btnLogin")
        ) {
            Text(text = "Login")
        }

    }
}