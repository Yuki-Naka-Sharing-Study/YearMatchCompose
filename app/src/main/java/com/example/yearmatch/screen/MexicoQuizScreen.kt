package com.example.yearmatch.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import sh.calvin.reorderable.rememberReorderableLazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import sh.calvin.reorderable.ReorderableItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MexicoQuizScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "🇲🇽",
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "戻る")
                    }
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = "年号と歴史的事情をドラッグ&ドロップで一致させてください。",
                    fontSize = 12.sp
                )
            }

            val years = listOf(
                1519,   // コルテスがメキシコに上陸
                1521,   // アステカ帝国の滅亡
                1535,   // ニュー・スペインの設立
                1810,   // ドロス・デ・セプティエンブレ
                1821,   // メキシコ独立戦争の勝利
                1846,   // 米墨戦争の勃発
                1848,   // グアダルーペ・イダルゴ条約
                1857,   // メキシコ憲法の制定
                1864,   // マクシミリアン帝国の成立
                1876,   // ポルフィリオ・ディアスの政権開始
                1910,   // メキシコ革命の勃発
                1915,   // セラヤの戦い
                1934,   // ラサロ・カルデナス大統領の改革
                1968,   // メキシコシティオリンピック
                1994,   // メキシコのNAFTA加盟
            )

            // **初期化時にシャッフル**
            var events by remember {
                mutableStateOf(
                    listOf(
                        "コルテスがメキシコに上陸",
                        "アステカ帝国の滅亡",
                        "ニュー・スペインの設立",
                        "ドロス・デ・セプティエンブレ",
                        "メキシコ独立戦争の勝利",
                        "米墨戦争の勃発",
                        "グアダルーペ・イダルゴ条約",
                        "メキシコ憲法の制定",
                        "マクシミリアン帝国の成立",
                        "ディアスの政権開始",
                        "メキシコ革命の勃発",
                        "セラヤの戦い",
                        "カルデナス大統領の改革",
                        "メキシコシティオリンピック",
                        "メキシコのNAFTA加盟"
                    ).shuffled()  // 🔥ここでランダム化🔥
                )
            }

            // ダイアログの状態を管理
            var showDialog by remember { mutableStateOf(false) }
            var dialogMessage by remember { mutableStateOf("") }

            // 並べ替え用の状態
            val lazyListState = rememberLazyListState()
            val reorderableLazyListState =
                rememberReorderableLazyListState(lazyListState) { from, to ->
                    events = events.toMutableList().apply {
                        add(to.index, removeAt(from.index))
                    }
                }

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Row(modifier = Modifier.fillMaxSize()) {
                    // 年号リスト（固定）
                    LazyColumn(
                        modifier = Modifier
                            .weight(0.22f)
                            .fillMaxHeight()
                            .padding(8.dp),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(years) { year ->
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(36.dp),
                                color = Color(0xFF9400d3)
                            ) {
                                Text(
                                    text = "$year",
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxWidth(),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                    }

                    // 歴史的事象リスト（ドラッグ＆ドロップ対応）
                    LazyColumn(
                        modifier = Modifier
                            .weight(0.7f)
                            .fillMaxHeight()
                            .padding(8.dp),
                        state = lazyListState,
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(events, key = { it }) { event ->
                            ReorderableItem(reorderableLazyListState, key = event) { isDragging ->
                                val elevation by animateDpAsState(if (isDragging) 4.dp else 0.dp)

                                Surface(shadowElevation = elevation) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(36.dp)
                                    ) {
                                        Text(event, Modifier.padding(horizontal = 8.dp))
                                        Spacer(modifier = Modifier.weight(1f))
                                        IconButton(
                                            modifier = Modifier.draggableHandle(),
                                            onClick = {},
                                        ) {
                                            Icon(Icons.Rounded.Menu, contentDescription = "Reorder")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // 「回答Button」を画面の下中央に配置
                Button(
                    onClick = {
                        // 回答チェック
                        val correctEvents = listOf(
                            "コルテスがメキシコに上陸",
                            "アステカ帝国の滅亡",
                            "ニュー・スペインの設立",
                            "ドロス・デ・セプティエンブレ",
                            "メキシコ独立戦争の勝利",
                            "米墨戦争の勃発",
                            "グアダルーペ・イダルゴ条約",
                            "メキシコ憲法の制定",
                            "マクシミリアン帝国の成立",
                            "ポルフィリオ・ディアスの政権開始",
                            "メキシコ革命の勃発",
                            "セラヤの戦い",
                            "ラサロ・カルデナス大統領の改革",
                            "メキシコシティオリンピック",
                            "メキシコのNAFTA加盟"
                        )

                        val results = events.zip(correctEvents) { userAnswer, correctAnswer ->
                            if (userAnswer == correctAnswer) "⭕ $userAnswer" else "❌ $userAnswer (正解: $correctAnswer)"
                        }

                        val correctCount = results.count { it.startsWith("⭕") }

                        dialogMessage = if (correctCount == years.size) {
                            "全問正解！ 🎉"
                        } else {
                            "${years.size}問中${correctCount}問正解！\n\n" + results.joinToString("\n")
                        }

                        showDialog = true
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000ff))
                ) {
                    Text("回答")
                }
            }

            // 結果を表示するダイアログ
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        Button(
                            onClick = { showDialog = false },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF808080))
                        ) {
                            Text("閉じる")
                        }
                    },
                    title = { Text("結果発表") },
                    text = { Text(dialogMessage) }
                )
            }
        }
    }
}