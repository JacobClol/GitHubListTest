package com.example.githublisttest.data.datasources

import com.example.githublisttest.data.services.ReposGitService
import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.domain.models.ReposGitParams
import javax.inject.Inject

class SearchGithubRemoteDataSourceImpl @Inject constructor(
    private val reposGitService: ReposGitService
) : SearchGithubRemoteDataSource {
    override suspend fun getRepositories(params: ReposGitParams): List<RepoGit> {
        return reposGitService.getReposGit(
            params.query,
            params.perPage,
            params.page
        ).toListRepoGit()
    }
}