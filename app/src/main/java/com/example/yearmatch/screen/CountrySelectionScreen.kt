package com.example.yearmatch.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountrySelectionScreen(navController: NavHostController) {
    // TODO : 他追加予定を検討している国
    // Sweden, 	Romania, Hungary, Hungary, Finland
    // Saudi Arabia, Afghanistan, South Africa
    // Ethiopia, Algeria, Cuba,
    // Argentina, Peru, Chile
    // Thailand, Vietnam, Indonesia
    // Malaysia, AustraliaCambodia

    val countries = listOf(
        "🇯🇵" to "japanQuiz",
        "🇨🇳" to "chinaQuiz",
        "🇰🇷" to "koreaQuiz",
        "🇷🇺" to "russiaQuiz",
        "🇺🇸" to "usaQuiz",
        "🇬🇧" to "ukQuiz",
        "🇩🇪" to "germanyQuiz",
        "🇫🇷" to "franceQuiz",
        "🇮🇹" to "italyQuiz",
        "🇳🇱" to "netherlandsQuiz",
        "🇵🇹" to "portugalQuiz",
        "🇪🇸" to "spainQuiz",
        "🇲🇳" to "mongoliaQuiz",
        "🇹🇷" to "türkiyeQuiz",
        "🇮🇱" to "israelQuiz",
        "🇵🇱" to "polandQuiz",
        "🇮🇳" to "indiaQuiz",
        "🇵🇰" to "pakistanQuiz",
        "🇮🇷" to "iranQuiz",
        "🇬🇷" to "greeceQuiz",
        "🇮🇶" to "iraqQuiz",
        "🇪🇬" to "egyptQuiz",
        "🇲🇽" to "mexicoQuiz",
        "🇦🇹" to "austriaQuiz",
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "国を選択してください")
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(16.dp)
            ) {
                items(countries.size) { index ->
                    val (flag, route) = countries[index]
                    Text(
                        text = flag,
                        fontSize = 100.sp, // 国旗を大きくする
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { navController.navigate(route) }
                    )
                }
            }
        }
    }
}
