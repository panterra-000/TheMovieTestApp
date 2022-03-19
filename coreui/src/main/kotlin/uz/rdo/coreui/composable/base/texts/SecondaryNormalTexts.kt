package uz.rdo.coreui.composable.base.texts

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun Text12spSecondary(text: String, color: Color = TheMovieTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}

@Composable
fun Text14spSecondary(text: String, color: Color = TheMovieTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}

@Composable
fun Text16spSecondary(text: String, color: Color = TheMovieTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = color, textAlign = TextAlign.Center,
    )
}


@Composable
fun Text24spSecondary(text: String, color: Color = TheMovieTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}

@Composable
fun Text48spSecondary(text: String, color: Color = TheMovieTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 48.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}

@Composable
fun Text36spSecondary(text: String, color: Color = TheMovieTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        color = color
    )
}