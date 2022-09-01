/*
 * Designed and developed by 2022 SungbinLand, Team Duckie
 *
 * [TabPlayground.kt] created by Ji Sungbin on 22. 8. 31. 오전 5:39
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/sungbinland/quack-quack/blob/main/LICENSE
 */

package team.duckie.quackquack.playground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.collections.immutable.persistentListOf
import team.duckie.quackquack.playground.theme.PlaygroundTheme

class TabPlayground : BaseActivity() {
    @Suppress("RemoveExplicitTypeArguments")
    private val items = persistentListOf<Pair<String, @Composable () -> Unit>>(
        "QuackMainTab" to { QuackMainTab() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                PlaygroundSection(
                    title = "Tab",
                    items = items,
                )
            }
        }
    }
}

@Composable
fun QuackMainTab() {
    var selectedMainTabIndex by remember { mutableStateOf(0) }

    team.duckie.quackquack.ui.component.QuackMainTab(
        titles = listOf(
            "판매중",
            "거래완료",
            "숨김",
        ),
        selectedTabIndex = selectedMainTabIndex,
        onTabSelected = { tabIndex ->
            selectedMainTabIndex = tabIndex
        },
    )
}