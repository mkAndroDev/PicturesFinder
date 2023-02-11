package com.krawczyk.maciej.repository.di

import com.krawczyk.maciej.networking.ApiHelper
import com.krawczyk.maciej.repository.Repository
import com.krawczyk.maciej.room.RoomDataStorage
import com.krawczyk.maciej.storage.StorageProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideApiHelper(): ApiHelper {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return ApiHelper(interceptor)
    }

    @Singleton
    @Provides
    fun provideStorageProvider(): StorageProvider {
        val roomDataStorage = RoomDataStorage()
        return StorageProvider(roomDataStorage)
    }

    @Singleton
    @Provides
    fun provideRepository(apiHelper: ApiHelper, storageProvider: StorageProvider): Repository {
        return Repository(apiHelper, storageProvider)
    }
}