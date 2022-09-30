package io.nirmal.croix.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.nirmal.croix.feature_auth.data.remote.AuthApi
import io.nirmal.croix.feature_auth.data.repository.AuthRepositoryImpl
import io.nirmal.croix.feature_auth.domain.repository.AuthRepository
import io.nirmal.croix.feature_auth.domain.use_case.AuthenticateUseCase
import io.nirmal.croix.feature_auth.domain.use_case.LoginUseCase
import io.nirmal.croix.feature_auth.domain.use_case.RegisterUseCase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthApi(client: OkHttpClient): AuthApi {
        return Retrofit.Builder()
            .baseUrl(AuthApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)

    }

    @Provides
    @Singleton
    fun provideRepository(api: AuthApi, sharedPreferences: SharedPreferences): AuthRepository {
        return AuthRepositoryImpl(api, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideRegisteredUseCae(repository: AuthRepository): RegisterUseCase {
        return RegisterUseCase(repository)
    }


    @Provides
    @Singleton
    fun provideLoginUseCae(repository: AuthRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAuthenticateUseCae(repository: AuthRepository): AuthenticateUseCase {
        return AuthenticateUseCase(repository)
    }
}