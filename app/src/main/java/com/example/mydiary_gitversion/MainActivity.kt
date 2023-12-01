package com.example.mydiary_gitversion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.mydiary_gitversion.navigation.Screen
import com.example.mydiary_gitversion.navigation.SetupNavGraph
import com.example.mydiary_gitversion.ui.theme.MyDiary_GitVersionTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MyDiary_GitVersionTheme {
                val navController = rememberNavController()
                SetupNavGraph(startDestination = Screen.Authentication.route ,
                    navController = navController )

            }

        }
    }
}

