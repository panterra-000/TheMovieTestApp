package uz.rdo.coreui.composable.base.texts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun Text12sp(text: String, color: Color = TheMovieTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}



@Composable
fun Text14sp(text: String, color: Color = TheMovieTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}



@Composable
fun Text16sp(text: String, color: Color = TheMovieTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = color, textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun Text24sp(text: String, color: Color = TheMovieTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}

@Composable
fun Text48sp(text: String, color: Color = TheMovieTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 48.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}
