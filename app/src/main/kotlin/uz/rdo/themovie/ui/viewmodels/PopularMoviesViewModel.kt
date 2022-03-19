package uz.rdo.themovie.ui.viewmodels

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
class PopularMoviesViewModel @Inject constructor(private val service: MainService) : ViewModel() {

    private val _popularMoviesState: MutableState<List<MovieItem?>?> = mutableStateOf(null)
    val popularMoviesState: State<List<MovieItem?>?> get() = _popularMoviesState

    private val _errorState = Channel<NetworkResponse.Error>()
    val errorState = _errorState.receiveAsFlow()

    private val _loaderState: MutableState<Boolean> = mutableStateOf(false)
    val loaderState: MutableState<Boolean> = _loaderState

    private var popularCounterState = 1

    fun getPopularMovies() {
        if (!loaderState.value) {
            loaderState.value = true
            viewModelScope.launch() {
                when (val resp = service.getPopularMovies(popularCounterState)) {
                    is NetworkResponse.Success -> {
                        val list: ArrayList<MovieItem?> = ArrayList()
                        _popularMoviesState.value?.let { list.addAll(it) }
                        resp.result.results?.let { list.addAll(it) }
                        _popularMoviesState.value = list
                        loaderState.value = false
                        popularCounterState++
                        Log.d("TAG909", "getPopularMovies (MainViewModel): ${resp.result.results} ")
                    }
                    is NetworkResponse.Error -> {
                        loaderState.value = false
                        _errorState.send(resp)
                        Log.d("TAG909", "getPopularMovies (MainViewModel): ${resp.message} ")
                    }
                }
            }
        }
    }
}