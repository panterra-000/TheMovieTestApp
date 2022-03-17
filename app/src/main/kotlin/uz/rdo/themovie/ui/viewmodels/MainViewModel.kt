package uz.rdo.themovie.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.rdo.core.BaseResponse
import uz.rdo.remote.service.main.MainService
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val service: MainService) : ViewModel() {

    fun getPopularMovies() {
        viewModelScope.launch {
            when (val resp = service.getPopularMovies()) {
                is BaseResponse.Success -> {
                    Log.d("TAG909", "getPopularMovies (MainViewModel): ${resp.result.results} ")
                }
                is BaseResponse.Error -> {
                    Log.d("TAG909", "getPopularMovies (MainViewModel): ${resp.message} ")
                }
            }
        }
    }
}