package com.example.githublisttest.domain.usecases

import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.domain.models.ReposGitParams
import com.example.githublisttest.domain.repositories.ReposGitRepository
import javax.inject.Inject

class GetReposGitUseCase @Inject constructor(
    private val repoGitRepository: ReposGitRepository
) {

    suspend operator fun invoke(reposGitParams: ReposGitParams): List<RepoGit>{
        return repoGitRepository.getReposGit(reposGitParams)
    }
}