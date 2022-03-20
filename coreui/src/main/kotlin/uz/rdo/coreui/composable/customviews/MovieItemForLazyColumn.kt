package uz.rdo.coreui.composable.customviews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.rdo.coreui.composable.base.Spacer10dp
import uz.rdo.coreui.composable.base.Spacer20dp
import uz.rdo.coreui.composable.base.texts.Text16spBoldActive
import uz.rdo.coreui.composable.base.texts.Text18spBold
import uz.rdo.coreui.composable.views.CorneredSquareImageView
import uz.rdo.coreui.viewdata.MovieItemViewData

@Composable
fun MovieItemForLazyColumn(itemData: MovieItemViewData?, onclick: () -> Unit) {
    Column(
        Modifier
            .padding(top = 10.dp, start = 20.dp, end = 20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CorneredSquareImageView(url = itemData?.posterPath) {
                onclick()
            }
            Spacer20dp()
            Column {
                Text18spBold(text = itemData?.title.toString())
                Spacer10dp()
                Text16spBoldActive(text = itemData?.realiseDate.toString())
            }
        }
    }
}