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
        composable("germanyQuiz") { GermanyQuizScreen(navHostController) }
        composable("italyQuiz") { ItalyQuizScreen(navHostController) }
        composable("netherlandsQuiz") { NetherlandsQuizScreen(navHostController) }
        composable("portugalQuiz") { PortugalQuizScreen(navHostController) }
        composable("spainQuiz") { SpainQuizScreen(navHostController) }
        composable("mongoliaQuiz") { MongoliaQuizScreen(navHostController) }
        composable("türkiyeQuiz") { TürkiyeQuizScreen(navHostController) }
        composable("indiaQuiz") { IndiaQuizScreen(navHostController) }
        composable("iranQuiz") { IranQuizScreen(navHostController) }
        composable("greeceQuiz") { GreeceQuizScreen(navHostController) }
        composable("iraqQuiz") { IraqQuizScreen(navHostController) }
        composable("egyptQuiz") { UkQuizScreen(navHostController) }
    }
}
