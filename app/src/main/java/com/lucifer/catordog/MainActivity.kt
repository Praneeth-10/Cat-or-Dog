package com.lucifer.catordog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucifer.catordog.screens.LandingPage
import com.lucifer.catordog.ui.theme.CatOrDogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatOrDogTheme {
                FunFactsApp()
            }
        }
    }
}

@Composable
fun FunFactsApp(navCon : NavHostController = rememberNavController()) {

    NavHost(navController = navCon, startDestination = "landing_page"){
        composable("landing_page"){
            LandingPage(navController = navCon)
        }
    }
}