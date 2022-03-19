package uz.rdo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.rdo.remote.service.actordetail.ActorDetailService
import uz.rdo.remote.service.moviedetail.MovieDetailService
import javax.inject.Inject

@HiltViewModel
class ActorDetailViewModel @Inject constructor(private val service: ActorDetailService) :
    ViewModel() {


}