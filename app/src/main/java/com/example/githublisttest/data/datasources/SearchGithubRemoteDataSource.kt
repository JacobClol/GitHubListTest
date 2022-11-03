package com.example.githublisttest.data.datasources

import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.domain.models.ReposGitParams

interface SearchGithubRemoteDataSource {

    suspend fun getRepositories(params: ReposGitParams) : List<RepoGit>
}