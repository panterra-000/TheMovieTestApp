package uz.rdo.presentation.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.rdo.coreui.R
import uz.rdo.coreui.composable.base.columns.ColumnScrollableFillMaxSize
import uz.rdo.coreui.composable.views.AppBarViewWithIcons
import uz.rdo.presentation.viewmodels.ActorDetailViewModel
import uz.rdo.presentation.viewmodels.MovieDetailViewModel
import uz.rdo.remote.data.response.actor.ActorDetailResponse
import uz.rdo.remote.data.response.actor.MovieCastItem
import uz.rdo.remote.data.response.movie.ActorCastItem

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
    }, castClick = {

    })

}

@Composable
fun ActorDetailScreenView(
    viewModel: ActorDetailViewModel,
    backClick: () -> Unit,
    castClick: (MovieCastItem) -> Unit
) {
    ColumnScrollableFillMaxSize {
        AppBarViewWithIcons(title = stringResource(R.string._title_detail),
            startIconClick = {
                backClick()
            })


    }
}