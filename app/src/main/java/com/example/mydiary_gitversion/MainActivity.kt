package com.example.mydiary_gitversion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.mydiary_gitversion.navigation.Screen
import com.example.mydiary_gitversion.navigation.SetupNavGraph
import com.example.mydiary_gitversion.ui.theme.MyDiary_GitVersionTheme
import com.example.mydiary_gitversion.util.Constants.APP_ID
import io.realm.kotlin.mongodb.App

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            MyDiary_GitVersionTheme {
                val navController = rememberNavController()
                SetupNavGraph(startDestination = getStartDestination() ,
                    navController = navController )

            }

        }
    }
}

private fun getStartDestination():String {
    val user = App.create(APP_ID).currentUser
    return if(user != null  && user.loggedIn){
        Screen.Home.route
    } else {
        Screen.Authentication.route

    }
}

