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
import uz.rdo.remote.data.response.movie.MovieDetailResponse
import uz.rdo.remote.service.moviedetail.MovieDetailService
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val service: MovieDetailService) :
    ViewModel() {

    private val _errorState = Channel<NetworkResponse.Error>()
    val errorState = _errorState.receiveAsFlow()

    private val _movieDetailState: MutableState<MovieDetailResponse?> = mutableStateOf(null)
    val movieDetailState get() = _movieDetailState

    private val _loaderState: MutableState<Boolean> = mutableStateOf(false)
    val loaderState: MutableState<Boolean> = _loaderState

    private val _creditsLoaderState: MutableState<Boolean> = mutableStateOf(false)
    val creditsLoaderState: MutableState<Boolean> = _creditsLoaderState

    private val _movieCreditsState: MutableState<List<CastItem?>?> = mutableStateOf(null)
    val movieCreditsState get() = _movieCreditsState

    fun getMovieDetail(id: String) {
        loaderState.value = true
        viewModelScope.launch() {
            when (val resp = service.getMovieDetailData(id)) {
                is NetworkResponse.Success -> {
                    _movieDetailState.value = resp.result
                    loaderState.value = false
                }
                is NetworkResponse.Error -> {
                    loaderState.value = false
                    _errorState.send(resp)
                }
            }
        }
    }

    fun getMovieCredits(id: String) {
        loaderState.value = true
        viewModelScope.launch() {
            when (val resp = service.getMovieCredits(id)) {
                is NetworkResponse.Success -> {
                    _movieCreditsState.value = resp.result.cast
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