package uz.rdo.themovie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.*
import uz.rdo.remote.service.main.MainService
import uz.rdo.remote.service.main.MainServiceImpl


@Module
@InstallIn(ViewModelComponent::class)
object ApiServiceModule {

    @Provides
    fun getMainService(authClient: HttpClient): MainService {
        return MainServiceImpl(authClient)
    }

}