package com.lucifer.catordog.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lucifer.catordog.R
import com.lucifer.catordog.components.TopAppBar
import com.lucifer.catordog.viewModels.UserInputViewModel

@Composable
fun WelcomeScreen(
    navHostController: NavHostController,
    userInputViewModel: UserInputViewModel = viewModel()
) {
    val nameEntered = userInputViewModel.uiIs.value.nameEntered
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
                strVal = stringResource(
                    id = R.string.welcome,
                    "$nameEntered \uD83D\uDE0A "
                )
            )

            Text(text = "Welcome Screen")
        }
    }

}