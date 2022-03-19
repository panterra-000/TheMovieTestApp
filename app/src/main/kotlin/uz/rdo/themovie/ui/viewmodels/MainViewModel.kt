package uz.rdo.themovie.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.rdo.core.BaseResponse
import uz.rdo.remote.data.response.MovieItem
import uz.rdo.remote.service.main.MainService
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val service: MainService) : ViewModel() {

    private val _popularMoviesState: MutableState<List<MovieItem?>?> = mutableStateOf(null)
    val popularMoviesState: State<List<MovieItem?>?> get() = _popularMoviesState

    fun getPopularMovies() {
        viewModelScope.launch {
            when (val resp = service.getPopularMovies()) {
                is BaseResponse.Success -> {
                    _popularMoviesState.value = resp.result.results
                    Log.d("TAG909", "getPopularMovies (MainViewModel): ${resp.result.results} ")
                }
                is BaseResponse.Error -> {
                    Log.d("TAG909", "getPopularMovies (MainViewModel): ${resp.message} ")
                }
            }
        }
    }
}