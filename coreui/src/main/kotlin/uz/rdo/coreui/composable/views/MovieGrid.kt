package uz.rdo.coreui.composable.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.rdo.coreui.composable.base.Spacer2dp
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSize
import uz.rdo.coreui.composable.base.texts.EllipsizeText12sp
import uz.rdo.remote.data.response.MovieItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesGrid(items: List<MovieItem?>, nextPage: () -> Unit, onclick: (MovieItem) -> Unit) {
    ColumnFillMaxSize {
       LazyVerticalGrid(
            columns = GridCells.Fixed(3), modifier = Modifier
                .fillMaxWidth()
        ) {
           itemsIndexed(items) { index, item ->
                if (index == items.lastIndex) {
                    nextPage()
                }
                if (item != null)
                    MovieItemView(
                        item = item
                    ) {
                        onclick(item)
                    }
            }
        }
    }
}

@Composable
fun MovieItemView(item: MovieItem, onclick: () -> Unit) {
    Column(
        Modifier
            .padding(10.dp)
            .height(170.dp)
    ) {
        CorneredImageViewFillWidth(url = item.posterPath) {
            onclick()
        }
        Spacer2dp()
        EllipsizeText12sp(text = item.title.toString())
    }
}
