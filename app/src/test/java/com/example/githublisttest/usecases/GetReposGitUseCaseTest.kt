package com.example.githublisttest.usecases

import com.example.githublisttest.domain.models.ReposGitParams
import com.example.githublisttest.domain.repositories.ReposGitRepository
import com.example.githublisttest.domain.usecases.GetReposGitUseCase
import com.example.githublisttest.testutils.relaxedMockk
import io.mockk.coVerify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetReposGitUseCaseTest {

    private val reposGitRepository = relaxedMockk<ReposGitRepository>()
    private lateinit var getReposGitUseCase: GetReposGitUseCase

    private val reposGitParams = ReposGitParams(
        query = "kotlin",
        perPage = "20",
        page = "1"
    )

    @Before
    fun setup() {
        getReposGitUseCase = GetReposGitUseCase(
            reposGitRepository
        )
    }

    @Test
    fun `when GerReposGitUseCase is invoke then should complete assigmente to fun getReposGit`() {

        runBlocking {
            getReposGitUseCase(reposGitParams)
        }

        coVerify(exactly = 1) {
            reposGitRepository.getReposGit(reposGitParams)
        }
    }
}