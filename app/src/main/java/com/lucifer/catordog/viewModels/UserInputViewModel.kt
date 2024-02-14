package com.lucifer.catordog.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lucifer.catordog.models.UserDataUiEvents
import com.lucifer.catordog.models.UserInputScreenState

class UserInputViewModel : ViewModel() {
    private val uiState = mutableStateOf(UserInputScreenState())

    var uiIs = uiState

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

    fun isValidState() : Boolean{
        return (uiState.value.nameEntered.isNotEmpty()
                &&
                uiState.value.animalSelected.isNotEmpty())
    }
}