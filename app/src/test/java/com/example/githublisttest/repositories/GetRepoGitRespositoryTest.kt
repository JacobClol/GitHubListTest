package com.example.githublisttest.repositories

import com.example.githublisttest.data.datasources.SearchGithubRemoteDataSource
import com.example.githublisttest.data.repositories.GetRepoGitRepositoryImpl
import com.example.githublisttest.domain.models.ReposGitParams
import com.example.githublisttest.testutils.relaxedMockk
import io.mockk.coVerify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRepoGitRespositoryTest {

    private lateinit var getRepoGitRepositoryImpl : GetRepoGitRepositoryImpl
    private val searchGithubRemoteDataSource = relaxedMockk<SearchGithubRemoteDataSource>()

    private val reposGitParams = ReposGitParams(
        query = "kotlin",
        perPage = "20",
        page = "1"
    )

    @Before
    fun setup(){
        getRepoGitRepositoryImpl = GetRepoGitRepositoryImpl(
            searchGithubRemoteDataSource
        )
    }

    @Test
    fun `when GetRepoGitRepository is called then shoud complete assigment to fun SearchGithubRemoteDataSource`(){
        runBlocking {
            getRepoGitRepositoryImpl.getReposGit(reposGitParams)
        }

        coVerify(exactly = 1) {
            searchGithubRemoteDataSource.getRepositories(reposGitParams)
        }
    }
}