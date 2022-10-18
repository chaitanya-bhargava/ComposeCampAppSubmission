package com.example.instagramclone.ui.theme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
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
import com.example.instagramclone.model.ProfilePost

@OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)
@Composable
fun ProfileScreenUI(
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
                contentDescription = "instalogotext",
                modifier = modifier
                    .padding(10.dp)
                    .height(50.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )

            Row(modifier = modifier.padding(10.dp)) {
                IconButton(onClick = homeClicked) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                }
                IconButton(onClick = messagesClicked) {
                    Icon(
                        imageVector = Icons.Filled.Message,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                }
                IconButton(onClick = profileClicked) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                }
                OutlinedButton(onClick = logoutClicked) {
                    Text("Logout", color = MaterialTheme.colors.onBackground)
                }
            }
        }
        Spacer(modifier = modifier.height(20.dp))
        Row(modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(10.dp)) {
            Image(
                painter = painterResource(id = R.drawable.image2),
                contentDescription = null,
                modifier = modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            Column(modifier = modifier.padding(10.dp)) {
                Text("12", modifier = modifier.padding(top = 10.dp, start = 10.dp).align(Alignment.CenterHorizontally), fontWeight = FontWeight.Bold)
                Text("Posts",modifier=modifier.padding(bottom = 10.dp, start = 10.dp))
            }
            Column(modifier = modifier.padding(10.dp)) {
                Text("368", modifier = modifier.padding(top = 10.dp, start = 10.dp).align(Alignment.CenterHorizontally), fontWeight = FontWeight.Bold)
                Text("Followers",modifier=modifier.padding(bottom = 10.dp, start = 10.dp))
            }
            Column(modifier = modifier.padding(10.dp)) {
                Text("399", modifier = modifier.padding(top = 10.dp, start = 10.dp).align(Alignment.CenterHorizontally), fontWeight = FontWeight.Bold)
                Text("Following",modifier=modifier.padding(bottom = 10.dp, start = 10.dp))
            }
        }
        Text(text= stringResource(R.string.user1), modifier = modifier.padding(top=10.dp, start = 30.dp),fontWeight = FontWeight.Bold)
        Text("Chaitanya Bhargava", modifier = modifier.padding(start = 30.dp))
        Spacer(modifier = modifier.height(30.dp))
        Text("Story Highlights", modifier = modifier.padding(20.dp), fontWeight = FontWeight.ExtraBold)
        LazyRow{
            items(Datasource().loadStoryHighlights()){
                    items->StoryBubble(items)
            }
        }
        Text("Posts", modifier = modifier.padding(20.dp), fontWeight = FontWeight.ExtraBold)
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 128.dp)
        ){
            items(Datasource().loadImages()){
                items-> ProfilePosts(items)
            }
        }
    }
}

@Composable
fun ProfilePosts(profilePost: ProfilePost,modifier:Modifier=Modifier){
    Image(
        painter = painterResource(id = profilePost.imageResource),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(3.dp)
        ,
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
    )
}

