package uz.rdo.coreui.composable.customviews

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
import uz.rdo.coreui.composable.base.texts.EllipsizeText16sp
import uz.rdo.coreui.composable.views.CorneredImageViewFillWidth
import uz.rdo.coreui.viewdata.MovieItemViewData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesGrid(
    itemData: List<MovieItemViewData?>,
    nextPage: () -> Unit,
    onclick: (MovieItemViewData) -> Unit
) {
    ColumnFillMaxSize {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(itemData) { index, item ->
                if (index == itemData.lastIndex) {
                    nextPage()
                }
                if (item != null)
                    MovieItemView(
                        itemData = item
                    ) {
                        onclick(item)
                    }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesGridTwoCells(
    itemData: List<MovieItemViewData?>,
    nextPage: () -> Unit,
    onclick: (MovieItemViewData) -> Unit
) {
    ColumnFillMaxSize {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(itemData) { index, item ->
                if (index == itemData.lastIndex) {
                    nextPage()
                }
                if (item != null)
                    MovieItemViewForTwoCells(
                        itemData = item
                    ) {
                        onclick(item)
                    }
            }
        }
    }
}


@Composable
fun MovieItemView(itemData: MovieItemViewData?, onclick: () -> Unit) {
    Column(
        Modifier
            .padding(10.dp)
            .height(170.dp)
    ) {
        CorneredImageViewFillWidth(url = itemData?.posterPath) {
            onclick()
        }
        Spacer2dp()
        EllipsizeText12sp(text = itemData?.title.toString())
    }
}

@Composable
fun MovieItemViewForTwoCells(itemData: MovieItemViewData?, onclick: () -> Unit) {
    Column(
        Modifier
            .padding(10.dp)
            .height(210.dp)
    ) {
        CorneredImageViewFillWidth(url = itemData?.posterPath) {
            onclick()
        }
        Spacer2dp()
        EllipsizeText16sp(text = itemData?.title.toString())
    }
}