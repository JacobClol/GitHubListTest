package com.example.githublisttest.di

import com.example.githublisttest.data.repositories.GetRepoGitRepositoryImpl
import com.example.githublisttest.domain.repositories.ReposGitRepository
import com.example.githublisttest.domain.usecases.GetReposGitUseCase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Reusable
    @Provides
    fun provideGetReposGitUseCase(
        repoGitRepository: ReposGitRepository
    ) =  GetReposGitUseCase(repoGitRepository)

}