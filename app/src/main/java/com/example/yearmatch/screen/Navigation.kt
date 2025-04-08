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
        composable("chinaQuiz") { ChinaQuizScreen(navHostController) }
        composable("koreaQuiz") { KoreaQuizScreen(navHostController) }
        composable("russiaQuiz") { RussiaQuizScreen(navHostController) }
        composable("usaQuiz") { UsaQuizScreen(navHostController) }
        composable("ukQuiz") { UkQuizScreen(navHostController) }
        composable("germanyQuiz") { UkQuizScreen(navHostController) }
        composable("italyQuiz") { UkQuizScreen(navHostController) }
        composable("netherlandsQuiz") { UkQuizScreen(navHostController) }
        composable("portugalQuiz") { UkQuizScreen(navHostController) }
        composable("spainQuiz") { UkQuizScreen(navHostController) }
        composable("mongoliaQuiz") { UkQuizScreen(navHostController) }
        composable("türkiyeQuiz") { UkQuizScreen(navHostController) }
        composable("indiaQuiz") { UkQuizScreen(navHostController) }
        composable("iranQuiz") { UkQuizScreen(navHostController) }
        composable("greeceQuiz") { UkQuizScreen(navHostController) }
        composable("iraqQuiz") { UkQuizScreen(navHostController) }
        composable("egyptQuiz") { UkQuizScreen(navHostController) }
    }
}
