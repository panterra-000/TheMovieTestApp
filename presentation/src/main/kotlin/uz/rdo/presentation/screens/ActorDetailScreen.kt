package uz.rdo.presentation.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.rdo.presentation.viewmodels.ActorDetailViewModel

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



}