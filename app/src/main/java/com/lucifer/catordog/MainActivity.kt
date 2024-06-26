package com.lucifer.catordog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucifer.catordog.screens.UserInputScreen
import com.lucifer.catordog.screens.WelcomeScreen
import com.lucifer.catordog.ui.theme.CatOrDogTheme
import com.lucifer.catordog.viewModels.UserInputViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CatOrDogTheme {
                FunFactsApp()
            }
        }
    }
}

@Composable
fun FunFactsApp(
    navCon: NavHostController = rememberNavController(),
    userInpViewModel: UserInputViewModel = viewModel()
) {
    Log.d("Test","Main Activity entered")
    NavHost(navController = navCon, startDestination = Routes.USER_INPUT_SCREEN) {
        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(
                navController = navCon,
                userInputViewModel = userInpViewModel
            )
        }
        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(
                navHostController = navCon,
                userInputViewModel = userInpViewModel
            )
        }
    }
}