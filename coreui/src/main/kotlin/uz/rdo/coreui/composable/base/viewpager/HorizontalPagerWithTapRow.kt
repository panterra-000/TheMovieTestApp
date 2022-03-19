package uz.rdo.coreui.composable.base.viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import uz.rdo.coreui.composable.base.texts.Text14sp
import uz.rdo.coreui.composable.base.texts.Text48sp
import uz.rdo.coreui.theme.TheMovieTheme

@ExperimentalPagerApi
@Composable
fun ColumnScope.HorizontalPagerWithTabRow(
    list: List<String>,
    content: @Composable PagerScope.(page: Int) -> Unit
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier
            .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .padding(horizontal = 3.dp)
                        .pagerTabIndicatorOffset(pagerState, tabPositions),
                    color = TheMovieTheme.colors.activeIconTint
                )
            },
        ) {
            list.forEachIndexed { index, title ->
                val selected = pagerState.currentPage == index
                Tab(
                    modifier = Modifier
                        .background(TheMovieTheme.colors.primary),
                    text = {
                        Text14sp(
                            text = title,
                            color = if (selected) TheMovieTheme.colors.primaryText else
                                TheMovieTheme.colors.secondaryText
                        )
                    },
                    selected = selected,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }

        HorizontalPager(list.size, state = pagerState) { page ->
            content(page)
        }
    }
}

