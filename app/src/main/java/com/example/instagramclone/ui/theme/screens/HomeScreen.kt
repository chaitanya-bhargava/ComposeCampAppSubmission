package com.example.instagramclone.ui.theme.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramclone.R
import com.example.instagramclone.data.Datasource
import com.example.instagramclone.model.Post
import com.example.instagramclone.model.Story

@Composable
fun HomeScreenUI(
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
        LazyRow{
            items(Datasource().loadStories()){
                items->StoryBubble(items)
            }
        }
        LazyColumn{
            items(Datasource().loadPosts()){
                items->PostsCard(items)
            }
        }
    }
}

@Composable
fun PostsCard(post: Post,modifier: Modifier=Modifier){
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(10.dp)
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )) {
        Column{
            Row(modifier = modifier.padding(10.dp)) {
                Image(
                    painter = painterResource(id = post.imageResource),
                    contentDescription = null,
                    modifier = modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
                Text(
                    text = stringResource(id = post.stringResource),
                    modifier = modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            var filledLike by remember {
                mutableStateOf(false)
            }
            Image(
                painter = painterResource(id = post.imageResource),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                IconButton(onClick = { filledLike=!filledLike }) {
                    Icon(
                        imageVector = if(!filledLike) Icons.Outlined.ThumbUp
                        else Icons.Filled.ThumbUp,
                        contentDescription = null,
                        modifier=modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = modifier.width(12.dp))
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Comment,
                        contentDescription = null,
                        modifier=modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = modifier.width(12.dp))
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = null,
                        modifier=modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.SaveAlt,
                        contentDescription = null,
                        modifier=modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}

@Composable
fun StoryBubble(story:Story,modifier: Modifier=Modifier){
    Column(modifier = modifier.padding(start = 10.dp, end = 10.dp)) {
        Image(
            painter = painterResource(id = story.imageResource),
            contentDescription = null,
            modifier = modifier
                .width(60.dp)
                .height(60.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
                .border(shape = CircleShape, width = 2.dp, color = MaterialTheme.colors.primary),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
        )
        Text(
            text = stringResource(id = story.stringResource),
            modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 10.sp
        )
    }
}