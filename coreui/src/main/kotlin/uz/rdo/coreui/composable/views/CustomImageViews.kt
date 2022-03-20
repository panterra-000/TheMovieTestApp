package uz.rdo.coreui.composable.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import uz.rdo.core.BuildConfig
import uz.rdo.coreui.R
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun RoundedImageView(size: Int, url: String?) {

    Image(
        painter = rememberImagePainter(
            data = if (url != null) "${BuildConfig.IMAGE_BASE_URL}/w500$url" else R.drawable.movie_place_holder,
            builder = {
                placeholder(R.drawable.movie_place_holder)
            }
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(size.dp)
            .clip(RoundedCornerShape(size / 2)),
    )
}


@Composable
fun CorneredImageViewFillWidth(height: Dp = 130.dp, url: String?, onclick: () -> Unit) {

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
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                onclick()
            },
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
            .width(90.dp)
            .height(height = height)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                onclick()
            },
    )
}


@Composable
fun BackDropImageWithAlpha(height: Dp = 240.dp, url: String?, onclick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Image(
            painter = rememberImagePainter(
                data = "${BuildConfig.IMAGE_BASE_URL}/w500$url",
                builder = {
                    Column(modifier = Modifier.background(TheMovieTheme.colors.primary)) {
                    }
                },
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onclick()
                },
        )

        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Red.copy(alpha = 0.7f), CircleShape)
        )

    }
}

