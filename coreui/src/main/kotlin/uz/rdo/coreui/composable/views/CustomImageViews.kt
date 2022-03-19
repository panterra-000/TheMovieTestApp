package uz.rdo.coreui.composable.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import uz.rdo.coreui.R

@Composable
fun RoundedImageView(size: Int, url: String?) {

    Image(
        painter = rememberImagePainter(
            data = url ?: R.drawable.movie_place_holder, builder = {
                placeholder(R.drawable.movie_place_holder)
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .size(size.dp)
            .clip(RoundedCornerShape(size / 2)),
    )

}


@Composable
fun CorneredImageView(height: Dp, url: String?) {

    Image(
        painter = rememberImagePainter(
            data = url ?: R.drawable.movie_place_holder, builder = {
                placeholder(R.drawable.movie_place_holder)
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .height(height)
            .clip(RoundedCornerShape(20.dp)),
    )

}