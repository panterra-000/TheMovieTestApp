package uz.rdo.themovie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.*
import uz.rdo.remote.service.actordetail.ActorDetailService
import uz.rdo.remote.service.actordetail.ActorDetailServiceImpl
import uz.rdo.remote.service.main.MainService
import uz.rdo.remote.service.main.MainServiceImpl
import uz.rdo.remote.service.moviedetail.MovieDetailService
import uz.rdo.remote.service.moviedetail.MovieDetailServiceImpl


@Module
@InstallIn(ViewModelComponent::class)
object ApiServiceModule {

    @Provides
    fun getMainService(authClient: HttpClient): MainService {
        return MainServiceImpl(authClient)
    }

    @Provides
    fun getMovieDetailService(authClient: HttpClient): MovieDetailService {
        return MovieDetailServiceImpl(authClient)
    }

    @Provides
    fun getActorDetailService(authClient: HttpClient): ActorDetailService {
        return ActorDetailServiceImpl(authClient)
    }
}