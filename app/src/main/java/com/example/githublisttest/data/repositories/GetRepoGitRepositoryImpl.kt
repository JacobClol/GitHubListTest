package com.example.githublisttest.data.repositories

import com.example.githublisttest.data.datasources.SearchGithubRemoteDataSource
import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.domain.models.ReposGitParams
import com.example.githublisttest.domain.repositories.ReposGitRepository
import javax.inject.Inject

class GetRepoGitRepositoryImpl @Inject constructor(
    private val searchGithubRemoteDataSource: SearchGithubRemoteDataSource
) : ReposGitRepository {
    override suspend fun getReposGit(queryParams: ReposGitParams): List<RepoGit> {
        return searchGithubRemoteDataSource.getRepositories(queryParams)
    }
}