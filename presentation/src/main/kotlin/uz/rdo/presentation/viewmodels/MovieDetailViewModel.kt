package uz.rdo.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.detail.MovieDetailResponse
import uz.rdo.remote.service.moviedetail.MovieDetailService
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val service: MovieDetailService) :
    ViewModel() {


    private val _movieDetailState: MutableState<MovieDetailResponse?> = mutableStateOf(null)
    val movieDetailState get() = _movieDetailState

    private val _errorState = Channel<NetworkResponse.Error>()
    val errorState = _errorState.receiveAsFlow()

    private val _loaderState: MutableState<Boolean> = mutableStateOf(false)
    val loaderState: MutableState<Boolean> = _loaderState


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
}