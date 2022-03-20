package uz.rdo.coreui.composable.base.texts

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun EllipsizeText12sp(text: String, color: Color = TheMovieTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = color, maxLines = 3,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun EllipsizeText16sp(text: String, color: Color = TheMovieTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = color, maxLines = 3,
        overflow = TextOverflow.Ellipsis
    )
}


