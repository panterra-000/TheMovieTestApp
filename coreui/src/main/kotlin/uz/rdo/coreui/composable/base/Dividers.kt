package uz.rdo.coreui.composable.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun DividerMin() {
    Spacer10dp()
    Divider(
        Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(TheMovieTheme.colors.primaryDividerBackground),
        color = TheMovieTheme.colors.primaryDividerBackground
    )
    Spacer10dp()
}