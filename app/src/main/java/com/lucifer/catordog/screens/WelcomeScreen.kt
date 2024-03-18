package com.lucifer.catordog.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lucifer.catordog.R
import com.lucifer.catordog.components.ButtonComponent
import com.lucifer.catordog.components.TextComponent
import com.lucifer.catordog.components.TextWithShadow
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
        println("=======Testing from remote /other user")
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
                strVal = stringResource(id = R.string.welcome).plus("$nameEntered \uD83D\uDE0D ")
            )

            TextComponent(textValue = "Thank You! For Sharing your Data", textSize = 24.sp)

            Spacer(modifier = Modifier.size(50.dp))

            val finalText = "You are a $animalEntered lover ${if (animalEntered =="Dog") "\uD83D\uDC30" else "\uD83D\uDC36" }"

            TextWithShadow(value = finalText)

            Card {
                Text(text = "$nameEntered have selected $animalEntered")
            }
            println("I guess everything just works out, let's see")

            ButtonComponent {
                navHostController.popBackStack()
//                navHostController.navigate(Routes.USER_INPUT_SCREEN)
            }

        }
    }

}
