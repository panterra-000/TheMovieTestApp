package uz.rdo.coreui.composable.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun AppLoaderCenter() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = TheMovieTheme.colors.primaryButtonBackground,
            modifier = Modifier
                .size(48.dp)
        )
    }
}