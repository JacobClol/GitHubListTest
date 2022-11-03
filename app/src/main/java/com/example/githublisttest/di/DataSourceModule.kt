package com.example.githublisttest.di

import com.example.githublisttest.data.datasources.SearchGithubRemoteDataSource
import com.example.githublisttest.data.datasources.SearchGithubRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Reusable
    abstract fun bindSearchGitHubRemoteDataSource(
        searchGithubRemoteDataSourceImpl: SearchGithubRemoteDataSourceImpl
    ): SearchGithubRemoteDataSource
}