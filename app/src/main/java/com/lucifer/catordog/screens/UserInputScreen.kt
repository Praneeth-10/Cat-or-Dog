package com.lucifer.catordog.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucifer.catordog.R
import com.lucifer.catordog.components.TextComponent
import com.lucifer.catordog.components.TextInputComponent
import com.lucifer.catordog.components.TopAppBar
import com.lucifer.catordog.models.UserDataUiEvents
import com.lucifer.catordog.viewModels.UserInputViewModel

@Composable
fun UserInputScreen(navController: NavController, userInputViewModel: UserInputViewModel = viewModel()) {
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

            Spacer(modifier = Modifier.size(60.dp))

            TextInputComponent(labelName = ""){
                userInputViewModel.onEventChanged()
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPrev() {
    UserInputScreen(rememberNavController())
}