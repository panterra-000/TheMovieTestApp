package uz.rdo.themovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import kotlinx.coroutines.InternalCoroutinesApi
import uz.rdo.themovie.ui.TheMovieMainComposableRoot

class MainActivity : ComponentActivity() {
    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    @ExperimentalUnitApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheMovieMainComposableRoot()
        }
    }
}
