package com.anelcc.tonal.di

import android.content.Context
import com.anelcc.tonal.data.Repository
import com.anelcc.tonal.domain.MoventUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    @Provides
    @Singleton
    fun provideRepository(moshi: Moshi, @ApplicationContext appContext: Context): Repository {
        return Repository(moshi, appContext)
    }

    @Provides
    @Singleton
    fun provideMoventUseCase(repository: Repository): MoventUseCase {
        return MoventUseCase(repository)
    }
}