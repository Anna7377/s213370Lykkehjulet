package com.example.s213370lykkehjulet

sealed class Screens(val route: String) {
    object WelcomeScreen : Screens("welcome_screen")
    object ScreenLayout : Screens("game_screen")
}
