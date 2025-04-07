package com.example.yearmatch.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = "countrySelection") {
        composable("countrySelection") { CountrySelectionScreen(navHostController) }
        composable("japanQuiz") { JapanQuizScreen(navHostController) }
        composable("koreaQuiz") { KoreaQuizScreen(navHostController) }
        composable("chinaQuiz") { ChinaQuizScreen(navHostController) }
        composable("usaQuiz") { UsaQuizScreen(navHostController) }
        composable("ukQuiz") { UkQuizScreen(navHostController) }
    }
}
