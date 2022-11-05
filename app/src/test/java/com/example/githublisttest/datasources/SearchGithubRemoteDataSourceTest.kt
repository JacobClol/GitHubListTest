package com.example.githublisttest.datasources

import com.example.githublisttest.data.datasources.SearchGithubRemoteDataSourceImpl
import com.example.githublisttest.data.services.ReposGitService
import com.example.githublisttest.domain.models.ReposGitParams
import com.example.githublisttest.testutils.relaxedMockk
import io.mockk.coVerify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SearchGithubRemoteDataSourceTest {

    private lateinit var searchGithubRemoteDataSourceImpl: SearchGithubRemoteDataSourceImpl
    private val reposGitService = relaxedMockk<ReposGitService>()

    private val reposGitParams = ReposGitParams(
        query = "kotlin",
        perPage = "20",
        page = "1"
    )

    @Before
    fun setup(){
        searchGithubRemoteDataSourceImpl = SearchGithubRemoteDataSourceImpl(
            reposGitService
        )
    }

    @Test
    fun `when SearchGithubRemoteDataSource is called then should complete assigment to fun ReposGitService`(){

        runBlocking {
            searchGithubRemoteDataSourceImpl.getRepositories(reposGitParams)
        }

        coVerify(exactly = 1) {
            reposGitService.getReposGit(
                query = "kotlin",
                perPage = "20",
                page = "1"
            )
        }
    }
}