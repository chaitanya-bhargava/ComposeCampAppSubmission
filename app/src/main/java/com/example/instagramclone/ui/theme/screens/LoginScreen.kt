package com.example.instagramclone.ui.theme.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instagramclone.R
import com.example.instagramclone.ui.theme.LoginViewModel

@Composable
fun LoginScreenUI(
    modifier: Modifier=Modifier,
    buttonClicked:()->Unit,
    loginViewModel: LoginViewModel= viewModel(),

){
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    val uiState by loginViewModel.uiState.collectAsState()
    Column(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)
        .wrapContentWidth(align = Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.instagram_logo),
            contentDescription ="instalogotext",
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .height(70.dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )
        OutlinedTextField(
            value =uiState.username,
            onValueChange ={loginViewModel.updateName(it,uiState.password)},
            placeholder = { Text("Enter your username")},
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
            )

        OutlinedTextField(
            value =uiState.password,
            onValueChange ={loginViewModel.updateName(uiState.username,it)},
            placeholder = { Text("Enter your password")},
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            }
        )
        val context: Context = LocalContext.current
        Button(
            onClick = {
                if(logged(uiState.username,uiState.password))
                    buttonClicked()
                else
                    Toast.makeText(context,"Invalid Credentials",Toast.LENGTH_SHORT).show()
                      },
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .height(50.dp)
            ) {
            Text(text = "Login", textAlign = TextAlign.Center, modifier = modifier.fillMaxWidth())
        }
        Spacer(modifier = modifier.height(50.dp))
        Column(modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .border(BorderStroke(2.dp, MaterialTheme.colors.onBackground))) {
            Icon(imageVector = Icons.Filled.Warning,
                contentDescription = null,
                modifier= modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally))
            Text(text = "As the app is in its early stages, kindly use only the following credentials to login:",
                modifier= modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            textAlign = TextAlign.Center)
            Text(text = "Username: testadmin    Password: 12345",modifier= modifier
                .padding(bottom = 30.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
                textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold)
        }
    }
}

fun logged(username:String,password:String): Boolean{
    return username=="testadmin" && password=="12345"
}
