package com.example.instagramclone.ui.theme.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.instagramclone.R
import com.example.instagramclone.data.Datasource
import com.example.instagramclone.model.Message

@Composable
fun MessageScreenUI(
    modifier: Modifier=Modifier,
    homeClicked:()->Unit,
    messagesClicked:()->Unit,
    profileClicked:()->Unit,
    logoutClicked:()->Unit
){
    Column(modifier = modifier) {
        Row(modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.instagram_logo),
                contentDescription ="instalogotext",
                modifier = modifier
                    .padding(10.dp)
                    .height(50.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )

            Row(modifier = modifier.padding(10.dp)) {
                IconButton(onClick = homeClicked) {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = null, tint = MaterialTheme.colors.onBackground)
                }
                IconButton(onClick = messagesClicked) {
                    Icon(imageVector = Icons.Filled.Message, contentDescription = null,tint = MaterialTheme.colors.onBackground)
                }
                IconButton(onClick = profileClicked) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = null,tint = MaterialTheme.colors.onBackground)
                }
                OutlinedButton(onClick = logoutClicked) {
                    Text("Logout", color = MaterialTheme.colors.onBackground)
                }
            }
        }
        LazyColumn{
            items(Datasource().loadMessages()){
                    items->MessagesCard(items)
            }
        }
    }
}

@Composable
fun MessagesCard(message:Message,modifier: Modifier=Modifier){
    Card(modifier = modifier
        .padding(10.dp)
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        ))
    {
        Row(modifier = modifier.padding(start=10.dp)) {
            Image(
                painter = painterResource(id = message.imageResource),
                contentDescription = null,
                modifier = modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            Column(modifier = modifier.padding(10.dp)) {
                Text(text = stringResource(id = message.user), modifier = modifier.padding(top = 10.dp, start = 10.dp), fontWeight = FontWeight.Bold)
                Text(text = stringResource(id = message.stringResource),modifier=modifier.padding(bottom = 10.dp, start = 10.dp))
            }
        }
    }
}