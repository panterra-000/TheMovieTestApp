package uz.rdo.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.rdo.coreui.R
import uz.rdo.coreui.composable.base.DividerMin
import uz.rdo.coreui.composable.base.Spacer10dp
import uz.rdo.coreui.composable.base.Spacer20dp
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSize
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxWidthPadding
import uz.rdo.coreui.composable.base.texts.*
import uz.rdo.coreui.composable.customviews.MovieItemForLazyColumn
import uz.rdo.coreui.composable.views.AppBarViewWithIcons
import uz.rdo.coreui.composable.views.AppLoader
import uz.rdo.coreui.composable.views.RoundedImageView
import uz.rdo.coreui.theme.TheMovieTheme
import uz.rdo.coreui.utils.getGenderFromApi
import uz.rdo.coreui.viewdata.MovieItemViewData
import uz.rdo.coreui.viewdata.movieMapperWithCastMovie
import uz.rdo.presentation.navigations.MovieDetailNavigation
import uz.rdo.presentation.viewmodels.ActorDetailViewModel
import uz.rdo.remote.data.response.actor.ActorDetailResponse

@ExperimentalUnitApi
@Composable
fun ActorDetailScreen(
    actorId: String,
    navController: NavController,
    viewModel: ActorDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.actorDetailState, block = {
        viewModel.getActorDetail(actorId)
    })

    LaunchedEffect(key1 = viewModel.actorCreditsState, block = {
        viewModel.getActorCredits(actorId)
    })

    LaunchedEffect(key1 = viewModel.errorState, block = {
        viewModel.errorState.collect {
            Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    })

    ActorDetailScreenView(viewModel = viewModel, backClick = {
        navController.navigateUp()
    }, movieItemClick = { movie ->
        if (movie.id != null) {
            navController.navigate(MovieDetailNavigation.createRoute(movieId = movie.id!!))
        }
    })
}

@Composable
fun ActorDetailScreenView(
    viewModel: ActorDetailViewModel,
    backClick: () -> Unit,
    movieItemClick: (MovieItemViewData) -> Unit
) {
    ColumnFillMaxSize {
        AppBarViewWithIcons(
            startIconClick = {
                backClick()
            })
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .background(TheMovieTheme.colors.primary)
        ) {
            item {
                if (viewModel.loaderState.value) {
                    AppLoader()
                } else {
                    viewModel.actorDetailState.value?.let {
                        ActorMainDetailView(it)
                    }
                }
            }

            if (viewModel.creditsLoaderState.value) {
                item {
                    AppLoader()
                }
            } else {
                viewModel.actorCreditsState.value?.let { cast ->
                    item {
                        ActorCreditsHeaderView()
                    }
                    items(cast.movieMapperWithCastMovie()) { movie ->
                        MovieItemForLazyColumn(itemData = movie) {
                            movieItemClick(movie)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ActorMainDetailView(actor: ActorDetailResponse) {
    ColumnFillMaxWidthPadding {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RoundedImageView(size = 120, url = actor.profilePath) {
            }
            Spacer20dp()
            Column() {
                Text24spBold(text = actor.name.toString())
                Spacer10dp()
                Text16spSecondary(text = stringResource(id = R.string._actor))
            }
        }
        Spacer20dp()
        Text16spBold(text = stringResource(R.string._biography))
        Spacer10dp()
        Text14spSecondary(text = actor.biography.toString())
        Spacer20dp()
        Text16spBold(text = stringResource(R.string._detail))
        Spacer10dp()
        LabeledRowText(label = stringResource(R.string._full_name), value = actor.name.toString())
        LabeledRowText(
            label = stringResource(R.string._birthday),
            value = actor.birthday.toString()
        )
        LabeledRowText(label = stringResource(R.string._death_day), value = actor.deathday ?: "")
        LabeledRowText(
            label = stringResource(R.string._place_of_birth),
            value = actor.placeOfBirth.toString()
        )
        LabeledRowText(
            label = stringResource(R.string._gender),
            value = actor.gender?.getGenderFromApi().toString()
        )
    }
}

@Composable
fun ActorCreditsHeaderView() {
    DividerMin()
    Box(Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
        Text16spBold(text = stringResource(R.string._cast_films))
    }
}
