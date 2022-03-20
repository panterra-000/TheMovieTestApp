package uz.rdo.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.movie.CastItem
import uz.rdo.remote.data.response.actor.ActorDetailResponse
import uz.rdo.remote.service.actordetail.ActorDetailService
import javax.inject.Inject

@HiltViewModel
class ActorDetailViewModel @Inject constructor(private val service: ActorDetailService) :
    ViewModel() {

    private val _errorState = Channel<NetworkResponse.Error>()
    val errorState = _errorState.receiveAsFlow()

    private val _actorDetailState: MutableState<ActorDetailResponse?> = mutableStateOf(null)
    val actorDetailState get() = _actorDetailState

    private val _loaderState: MutableState<Boolean> = mutableStateOf(false)
    val loaderState: MutableState<Boolean> = _loaderState

    private val _creditsLoaderState: MutableState<Boolean> = mutableStateOf(false)
    val creditsLoaderState: MutableState<Boolean> = _creditsLoaderState

    private val _actorCreditsState: MutableState<List<CastItem?>?> = mutableStateOf(null)
    val actorCreditsState get() = _actorCreditsState

    fun getMovieDetail(id: String) {
        loaderState.value = true
        viewModelScope.launch() {
            when (val resp = service.getActorDetailData(id)) {
                is NetworkResponse.Success -> {
                    _actorDetailState.value = resp.result
                    loaderState.value = false
                }
                is NetworkResponse.Error -> {
                    loaderState.value = false
                    _errorState.send(resp)
                }
            }
        }
    }

}