package uz.rdo.themovie.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import uz.rdo.core.http.httpClient

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesHttpClient(@ApplicationContext context: Context): HttpClient {
        return httpClient(context)
    }

}