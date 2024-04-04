package apps.sumit.rollthedice.di

import apps.sumit.rollthedice.common.Constants.BASE_URL
import apps.sumit.rollthedice.data.remote.DiceAPI
import apps.sumit.rollthedice.data.remote.repository.RepositoryImpl
import apps.sumit.rollthedice.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): DiceAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DiceAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideDiceRepository(api: DiceAPI): Repository {
        return RepositoryImpl(api)
    }
}