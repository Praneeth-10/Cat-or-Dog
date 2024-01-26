package com.lucifer.catordog.models

sealed class UserDataUiEvents {
    data class UserNameEntered(val name : String) : UserDataUiEvents()
    data class AnimalEntered(val animal : String) : UserDataUiEvents()
}