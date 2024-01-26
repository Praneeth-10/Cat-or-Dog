package com.lucifer.catordog.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lucifer.catordog.models.UserDataUiEvents
import com.lucifer.catordog.models.UserInputScreenState

class UserInputViewModel : ViewModel() {
    private var uiState = mutableStateOf(UserInputScreenState())

    fun onEventChanged(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvents.AnimalEntered
            -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animal
                )
            }
        }
    }

}