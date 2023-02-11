package com.krawczyk.maciej.repository.di

import com.krawczyk.maciej.repository.Repository
import com.krawczyk.maciej.searchUseCase.SearchExecutor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchUseCaseModule {

    @Singleton
    @Provides
    fun provideSearchExecutor(repository: Repository): SearchExecutor {
        return SearchExecutor(repository)
    }
}