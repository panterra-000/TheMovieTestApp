package uz.rdo.coreui.composable.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import uz.rdo.core.BuildConfig
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
fun CorneredImageView(height: Dp = 130.dp, url: String?, onclick: () -> Unit) {

    Image(
        painter = rememberImagePainter(
            data = "${BuildConfig.IMAGE_BASE_URL}/w500$url",
            builder = {
                placeholder(R.drawable.movie_place_holder)
            },
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onclick()
            },
    )

}