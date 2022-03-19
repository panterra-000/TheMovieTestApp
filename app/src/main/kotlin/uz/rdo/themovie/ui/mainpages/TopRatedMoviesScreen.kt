package uz.rdo.themovie.ui.mainpages

import androidx.compose.runtime.Composable
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSizeWithPadding
import uz.rdo.coreui.composable.base.textfields.SearchTextFieldRounded
import uz.rdo.coreui.composable.base.texts.Text16spSecondary
import uz.rdo.themovie.ui.viewmodels.PopularMoviesViewModel

@Composable
fun TopRatedMoviesScreen(viewModel: PopularMoviesViewModel) {
    TopRatedMoviesScreenView()
}

@Composable
fun TopRatedMoviesScreenView() {
    ColumnFillMaxSizeWithPadding {
        SearchTextFieldRounded() {

        }
        Text16spSecondary(text = "TopRated")
    }
}


