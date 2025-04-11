package com.example.yearmatch.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun CountrySelectionScreen(navController: NavHostController) {
    val countries = listOf(
        "🇯🇵" to "japanQuiz",
        "🇨🇳" to "chinaQuiz",
        "🇰🇷" to "koreaQuiz",
        "🇷🇺" to "russiaQuiz",
        "🇺🇸" to "usaQuiz",
        "🇬🇧" to "ukQuiz",
        "🇩🇪" to "germanyQuiz",
        "🇮🇹" to "italyQuiz",
        "🇳🇱" to "netherlandsQuiz",
        "🇵🇹" to "portugalQuiz",
        "🇪🇸" to "spainQuiz",
        "🇲🇳" to "mongoliaQuiz",
        "🇹🇷" to "türkiyeQuiz",
        "🇮🇳" to "indiaQuiz",
        "🇮🇷" to "iranQuiz",
        "🇬🇷" to "greeceQuiz",
        "🇮🇶" to "iraqQuiz",
        "🇪🇬" to "egyptQuiz"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "国を選択してください",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )


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
