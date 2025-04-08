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
        "日本" to "japanQuiz", // 日本を先頭に固定

        // 1. 直接の隣国で歴史的関係が深い国
        "中国" to "chinaQuiz",     // 遣唐使・遣隋使、明・清との関係、日中戦争
        "韓国" to "koreaQuiz",     // 百済・新羅・高麗・朝鮮、日韓併合、戦後関係
        "ロシア" to "russiaQuiz",  // 北方領土問題、日露戦争、冷戦時代の影響

        // 2. 近代以降で特に影響の大きい国
        "アメリカ" to "usaQuiz",   // ペリー来航、太平洋戦争、戦後占領、経済関係
        "イギリス" to "ukQuiz",    // 日英同盟、幕末の開国、外交・経済関係
        "ドイツ" to "germanyQuiz", // 日独伊三国同盟、明治期の制度導入
        "イタリア" to "italyQuiz", // 三国同盟、文化的影響

        // 3. 戦国・江戸時代から関わりのあった国
        "オランダ" to "netherlandsQuiz", // 江戸時代の出島貿易、蘭学
        "ポルトガル" to "portugalQuiz", // 種子島への鉄砲伝来、キリスト教布教
        "スペイン" to "spainQuiz",       // 南蛮貿易、フィリピン経由の影響

        // 4. アジア・中東の影響国
        "モンゴル" to "mongoliaQuiz", // 元寇
        "トルコ" to "türkiyeQuiz",    // 親日国、戦時中の関係
        "インド" to "indiaQuiz",      // 仏教・戦時中のインド独立運動支援
        "イラン" to "iranQuiz",       // 石油輸入、戦前の交流

        // 5. 古代文明・影響を受けた国々
        "ギリシャ" to "greeceQuiz",  // 哲学・西洋思想の影響
        "イラク" to "iraqQuiz",      // メソポタミア文明の影響
        "エジプト" to "egyptQuiz"    // 古代文明としての影響
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
                val (name, route) = countries[index]
                Text(
                    text = name,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { navController.navigate(route) }
                )
            }
        }
    }
}
