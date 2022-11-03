package com.example.githublisttest.di

import com.example.githublisttest.data.repositories.GetRepoGitRepositoryImpl
import com.example.githublisttest.domain.repositories.ReposGitRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Reusable
    abstract fun bindGetRepoGitRepository(
        getRepoGitRepositoryImpl: GetRepoGitRepositoryImpl
    ): ReposGitRepository
}