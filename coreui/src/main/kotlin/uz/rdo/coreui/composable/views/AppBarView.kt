package uz.rdo.coreui.composable.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.rdo.coreui.R
import uz.rdo.coreui.composable.base.texts.Text16spBold
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun AppBarView(title: String) {
    TopAppBar(backgroundColor = TheMovieTheme.colors.primary) {
        Spacer(modifier = Modifier.weight(1f))
        Text16spBold(text = title)
        Spacer(modifier = Modifier.weight(1f))
    }
}

const val BOTTOM_BAR_HEIGHT = 56


@Composable
fun AppBarViewWithIcons(title: String = "", startIconClick: () -> Unit) {
    TopAppBar(backgroundColor = TheMovieTheme.colors.primary) {
        Box(Modifier.fillMaxSize()) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                tint = TheMovieTheme.colors.primaryText,
                modifier = Modifier
                    .width(BOTTOM_BAR_HEIGHT.dp)
                    .fillMaxHeight()
                    .clickable {
                        startIconClick.invoke()
                    }
                    .padding(15.dp)
            )
            Box(modifier = Modifier.align(Alignment.Center)) {
                Text16spBold(text = title)
            }
        }
    }
}





