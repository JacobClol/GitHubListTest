package com.example.githublisttest.domain.repositories

import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.domain.models.ReposGitParams

interface ReposGitRepository {
    suspend fun getReposGit(queryParams: ReposGitParams) : List<RepoGit>
}