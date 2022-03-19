package uz.rdo.themovie.ui.mainpages

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSizeWithPadding
import uz.rdo.coreui.composable.base.textfields.SearchTextFieldRounded
import uz.rdo.coreui.composable.base.texts.Text16spSecondary
import uz.rdo.themovie.ui.viewmodels.PopularMoviesViewModel

@Composable
fun UpcomingMoviesScreen(viewModel: PopularMoviesViewModel = hiltViewModel()) {
    UpcomingMoviesScreenView()
}

@Composable
fun UpcomingMoviesScreenView() {
    ColumnFillMaxSizeWithPadding {
        SearchTextFieldRounded() {

        }
        Text16spSecondary(text = "Upcoming")
    }
}


