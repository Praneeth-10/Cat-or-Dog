package com.lucifer.catordog.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lucifer.catordog.R
import com.lucifer.catordog.components.ButtonComponent
import com.lucifer.catordog.components.TopAppBar
import com.lucifer.catordog.viewModels.UserInputViewModel

@Composable
fun WelcomeScreen(
    navHostController: NavHostController,
    userInputViewModel: UserInputViewModel = viewModel()
) {
    val nameEntered = userInputViewModel.uiIs.value.nameEntered
    val animalEntered = userInputViewModel.uiIs.value.animalSelected
    LaunchedEffect(key1 = nameEntered) {
//      AnimatedVisibility(visible = true) {
//
//      }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopAppBar(
                strVal = stringResource(id = R.string.welcome).plus("$nameEntered \uD83D\uDE0A ")
            )

            Text(text = "Welcome Screen")

            Card {
                Text(text = "$nameEntered have selected $animalEntered")
            }
            ButtonComponent {
                navHostController.popBackStack()
//                navHostController.navigate(Routes.USER_INPUT_SCREEN)
            }

        }
    }

}