package com.lucifer.catordog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lucifer.catordog.R
import com.lucifer.catordog.Routes
import com.lucifer.catordog.components.AnimalCard
import com.lucifer.catordog.components.ButtonComponent
import com.lucifer.catordog.components.TextComponent
import com.lucifer.catordog.components.TextInputComponent
import com.lucifer.catordog.components.TopAppBar
import com.lucifer.catordog.models.UserDataUiEvents
import com.lucifer.catordog.viewModels.UserInputViewModel

@Composable
fun UserInputScreen(
    navController: NavHostController,
    userInputViewModel: UserInputViewModel = viewModel()
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopAppBar(stringResource(id = R.string.hi_there))

            Spacer(modifier = Modifier.height(20.dp))

            TextComponent(
                textValue = stringResource(id = R.string.lets_learn_about),
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            TextComponent(
                textValue = stringResource(id = R.string.app_will_prepare),
                textSize = 20.sp
            )

            Spacer(modifier = Modifier.size(50.dp))

            TextInputComponent(labelName = "Enter Nam", valueIs = userInputViewModel.uiIs.value.nameEntered) {
                userInputViewModel.onEventChanged(event = UserDataUiEvents.UserNameEntered(it))
            }

            Spacer(modifier = Modifier.size(30.dp))

            TextComponent(
                textValue = stringResource(id = R.string.what_do_you_like),
                textSize = 20.sp
            )
            Spacer(modifier = Modifier.size(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                AnimalCard(
                    imgVector = Icons.Outlined.AccountCircle,
                    imgDescription = stringResource(id = R.string.cat),
                    selected = userInputViewModel.uiIs.value.animalSelected == "Cat"
                ) {
                    userInputViewModel.onEventChanged(UserDataUiEvents.AnimalEntered(it))
                }
                AnimalCard(
                    imgVector = Icons.Outlined.AccountBox,
                    imgDescription = stringResource(id = R.string.dog),
                    selected = userInputViewModel.uiIs.value.animalSelected == "Dog"
                ) {
                    userInputViewModel.onEventChanged(UserDataUiEvents.AnimalEntered(it))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()){
                ButtonComponent(goToDetailScreen = {
                    println("===================Going to")
                    println("=================== ${userInputViewModel.uiIs.value.nameEntered} and ${userInputViewModel.uiIs.value.animalSelected}")
                    navController.navigate(Routes.WELCOME_SCREEN)
                })
            }

        }
    }
}

@Preview
@Composable
fun UserInputScreenPrev() {
    UserInputScreen(rememberNavController())
}