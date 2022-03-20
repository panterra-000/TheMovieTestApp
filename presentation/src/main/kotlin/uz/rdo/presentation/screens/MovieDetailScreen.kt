package uz.rdo.presentation.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.rdo.coreui.R
import uz.rdo.coreui.composable.base.DividerMin
import uz.rdo.coreui.composable.base.Spacer10dp
import uz.rdo.coreui.composable.base.Spacer20dp
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxWidthPadding
import uz.rdo.coreui.composable.base.columns.ColumnScrollableFillMaxSize
import uz.rdo.coreui.composable.base.texts.LabeledRowText
import uz.rdo.coreui.composable.base.texts.Text14spSecondary
import uz.rdo.coreui.composable.base.texts.Text16spBold
import uz.rdo.coreui.composable.views.AppBarViewWithIcons
import uz.rdo.coreui.composable.views.AppLoaderCenter
import uz.rdo.coreui.composable.views.MovieHeaderWithImage
import uz.rdo.coreui.utils.timeSeparation
import uz.rdo.presentation.viewmodels.MovieDetailViewModel
import uz.rdo.remote.data.response.detail.MovieDetailResponse

@Composable
fun MovieDetailScreen(
    movieId: String,
    navController: NavController,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getMovieDetail(movieId)
    })

    LaunchedEffect(key1 = Unit, block = {
        viewModel.errorState.collect {
            Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    })

    viewModel.movieDetailState.value?.let {
        MovieDetailScreenView(movie = it) {
            navController.navigateUp()
        }
    }

    if (viewModel.loaderState.value) {
        AppLoaderCenter()
    }
}

@Composable
fun MovieDetailScreenView(movie: MovieDetailResponse, backClick: () -> Unit) {
    ColumnScrollableFillMaxSize {
        AppBarViewWithIcons(title = stringResource(R.string._title_detail),
            startIconClick = {
                backClick()
            })
        MovieHeaderWithImage(
            coverImgUrl = movie.backdropPath.toString(),
            posterImgUrl = movie.posterPath.toString(),
            title = movie.originalTitle.toString()
        )
        DividerMin()
        ColumnFillMaxWidthPadding {
            Spacer20dp()
            Text16spBold(text = stringResource(R.string._overview))
            Spacer10dp()
            Text14spSecondary(text = movie.overview.toString())
            Spacer20dp()
            Text16spBold(text = stringResource(R.string._facts))
            Spacer10dp()
            LabeledRowText(label = stringResource(R.string._status), value = movie.status.toString())
            LabeledRowText(label = stringResource(R.string._realise_date), value = movie.releaseDate.toString())
            LabeledRowText(label = stringResource(R.string._original_language), value = movie.originalLanguage.toString())
            LabeledRowText(label = stringResource(R.string._runtime), value = (movie.runtime ?: 0).timeSeparation())
            LabeledRowText(label = stringResource(R.string._budget), value = "\$${movie.budget.toString()}")
            LabeledRowText(label = stringResource(R.string._revenue), value = "\$${movie.revenue.toString()}")



        }
    }
}