package com.example.instagramclone.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagramclone.ui.theme.screens.HomeScreenUI
import com.example.instagramclone.ui.theme.screens.LoginScreenUI
import com.example.instagramclone.ui.theme.screens.MessageScreenUI
import com.example.instagramclone.ui.theme.screens.ProfileScreenUI

enum class TestNames{
    Login,
    Home,
    Messages,
    Profile
}

@Composable
fun InstaNavigation(
    modifier: Modifier=Modifier,
    navController: NavHostController= rememberNavController()
){
    NavHost(
        modifier=modifier,
        navController = navController,
        startDestination = TestNames.Login.name
    ){
        composable(route = TestNames.Login.name){
            LoginScreenUI(Modifier,{navController.navigate(TestNames.Home.name)})
        }
        composable(route = TestNames.Home.name){
            HomeScreenUI(Modifier,{},{
                navController.navigate(TestNames.Messages.name)
            },{
                navController.navigate(TestNames.Profile.name)
            },{
                navController.navigate(TestNames.Login.name){popUpTo(TestNames.Login.name){
                    inclusive=true
                } }
            })
        }
        composable(route = TestNames.Messages.name){
            MessageScreenUI(Modifier,{
                navController.navigate(TestNames.Home.name)
            },{},{
                navController.navigate(TestNames.Profile.name)
            },{
                navController.navigate(TestNames.Login.name){popUpTo(TestNames.Login.name){
                    inclusive=true
                } }
            })
        }
        composable(route = TestNames.Profile.name){
            ProfileScreenUI(Modifier,{
                navController.navigate(TestNames.Home.name)
            },{
                navController.navigate(TestNames.Messages.name)
            },{},{
                navController.navigate(TestNames.Login.name){popUpTo(TestNames.Login.name){
                    inclusive=true
                } }
            })
        }
    }
}

