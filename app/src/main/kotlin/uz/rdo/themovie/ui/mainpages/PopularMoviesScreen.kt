package uz.rdo.themovie.ui.mainpages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSize
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSizeWithPadding
import uz.rdo.coreui.composable.base.textfields.SearchTextField
import uz.rdo.coreui.composable.base.textfields.SearchTextFieldRounded
import uz.rdo.coreui.composable.base.texts.Text16spSecondary
import uz.rdo.themovie.ui.viewmodels.MainViewModel

@Composable
fun PopularMoviesScreen(viewModel: MainViewModel) {
    PopularMoviesScreenView()
}

@Composable
fun PopularMoviesScreenView() {
    ColumnFillMaxSizeWithPadding {
        SearchTextFieldRounded() {

        }
        Text16spSecondary(text = "Popular")
    }
}


