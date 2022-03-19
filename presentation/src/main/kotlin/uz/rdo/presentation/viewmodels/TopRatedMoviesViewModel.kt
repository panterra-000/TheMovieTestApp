package uz.rdo.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.MovieItem
import uz.rdo.remote.service.main.MainService
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(private val service: MainService) : ViewModel() {

    private val _moviesState: MutableState<List<MovieItem?>?> = mutableStateOf(null)
    val moviesState: State<List<MovieItem?>?> get() = _moviesState

    private val _errorState = Channel<NetworkResponse.Error>()
    val errorState = _errorState.receiveAsFlow()

    private val _loaderState: MutableState<Boolean> = mutableStateOf(false)
    val loaderState: MutableState<Boolean> = _loaderState

    private var mounterState = 1

    fun getTopRatedMovies() {
        if (!loaderState.value) {
            loaderState.value = true
            viewModelScope.launch() {
                when (val resp = service.getTopRatedMovies(mounterState)) {
                    is NetworkResponse.Success -> {
                        val list: ArrayList<MovieItem?> = ArrayList()
                        _moviesState.value?.let { list.addAll(it) }
                        resp.result.results?.let { list.addAll(it) }
                        _moviesState.value = list
                        loaderState.value = false
                        mounterState++
                        Log.d("TAG909", "getTopRatedMovies(): ${resp.result.results} ")
                    }
                    is NetworkResponse.Error -> {
                        loaderState.value = false
                        _errorState.send(resp)
                        Log.d("TAG909", "getTopRatedMovies(): ${resp.message} ")
                    }
                }
            }
        }
    }
}