package uz.rdo.coreui.composable.customviews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.rdo.coreui.composable.base.Spacer10dp
import uz.rdo.coreui.composable.base.texts.Text14spSecondary
import uz.rdo.coreui.composable.base.texts.Text16spBold
import uz.rdo.coreui.composable.views.RoundedImageView

@Composable
fun PersonItemView(fullName: String, character: String, avatarUrl: String?, onclick: () -> Unit) {
    Column(
        Modifier
            .padding(end = 10.dp)
            .width(100.dp)
    ) {
        RoundedImageView(size = 100, url = avatarUrl) {
            onclick()
        }
        Spacer10dp()
        Text16spBold(text = fullName)
        Text14spSecondary(text = character)
    }
}