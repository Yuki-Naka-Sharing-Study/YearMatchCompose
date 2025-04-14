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
fun PolandQuizScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "🇵🇱",
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
                    text = "固定の年号に対して\n" +
                            "歴史的事情をドラッグ&ドロップで一致させてください。",
                    fontSize = 12.sp
                )
            }

            val years = listOf(
                966,    // ポーランドのキリスト教化（メシュコ1世の洗礼）
                1025,   // ボレスワフ1世の即位：ポーランド王国の誕生
                1138,   // ピャスト朝の分割：ポーランド王国の分裂
                1226,   // テンプル騎士団によるポモージェ（ポーランド北部）の支配開始
                1364,   // ヤゲウォ大学（クラクフ大学）創立
                1410,   // グルンヴァルトの戦い（タタール人とドイツ騎士団との戦い）
                1569,   // ルブリン連合：ポーランドとリトアニアの連邦化（ポーランド・リトアニア共和国）
                1596,   // ブレスト・リトフスク公会議（カトリックと東方教会の統合）
                1648,   // ハトマンの反乱：コサックの反乱（ウクライナとの戦争）
                1683,   // ウィーン包囲戦：ポーランドのヤン3世ソビエスキがオスマン帝国を撃退
                1772,   // 第1次ポーランド分割：ロシア・プロイセン・オーストリアによる領土分割
                1791,   // ポーランド憲法の制定（世界初の近代憲法の一つ）
                1795,   // 第3次ポーランド分割：ポーランド王国消滅、ロシア・プロイセン・オーストリアによる完全支配
                1918,   // 第1次世界大戦後、ポーランド再建：ポーランド共和国独立回復
                1980,   // "連帯"（Solidarność）運動開始：反ソ連・反共産主義運動
            )

            // **初期化時にシャッフル**
            var events by remember {
                mutableStateOf(
                    listOf(
                        "メシュコ1世の洗礼",
                        "ボレスワフ1世の即位",
                        "ピャスト朝の分割",
                        "テンプル騎士団による支配開始",
                        "ヤゲウォ大学創立",
                        "グルンヴァルトの戦い",
                        "ルブリン連合",
                        "ブレスト・リトフスク公会議",
                        "ハトマンの反乱",
                        "ウィーン包囲戦",
                        "第1次ポーランド分割",
                        "ポーランド憲法の制定",
                        "第3次ポーランド分割",
                        "ポーランド再建",
                        "連帯運動開始",
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
                            "メシュコ1世の洗礼",
                            "ボレスワフ1世の即位",
                            "ピャスト朝の分割",
                            "テンプル騎士団による支配開始",
                            "ヤゲウォ大学創立",
                            "グルンヴァルトの戦い",
                            "ルブリン連合",
                            "ブレスト・リトフスク公会議",
                            "ハトマンの反乱",
                            "ウィーン包囲戦",
                            "第1次ポーランド分割",
                            "ポーランド憲法の制定",
                            "第3次ポーランド分割",
                            "ポーランド再建",
                            "連帯運動開始",
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