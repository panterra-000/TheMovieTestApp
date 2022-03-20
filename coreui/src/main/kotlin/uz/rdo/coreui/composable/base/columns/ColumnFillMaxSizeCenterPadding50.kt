package uz.rdo.coreui.composable.base.columns

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun ColumnFillMaxSizeCenterPadding50(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        content()
    }
}

@Composable
fun ColumnFillMaxSize(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TheMovieTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        content()
    }
}

@Composable
fun ColumnScrollableFillMaxSize(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(TheMovieTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        content()
    }
}

@Composable
fun ColumnFillMaxWidthPadding(
    horizontalPadding: Dp = 20.dp,
    verticalPadding: Dp = 0.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(TheMovieTheme.colors.primary)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
    )
    {
        content()
    }
}


@Composable
fun ColumnFillMaxSizeWithPadding(
    horizontalPadding: Dp = 10.dp,
    verticalPadding: Dp = 10.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TheMovieTheme.colors.primary)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        content()
    }
}
