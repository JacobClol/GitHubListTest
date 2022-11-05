package com.example.githublisttest.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.domain.models.ReposGitParams
import com.example.githublisttest.domain.usecases.GetReposGitUseCase
import com.example.githublisttest.testutils.relaxedMockk
import com.example.githublisttest.ui.viewmodel.ListRepoViewModel
import io.mockk.coEvery
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListRepoViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var listRepoViewModel: ListRepoViewModel
    private val getReposGitUseCase = relaxedMockk<GetReposGitUseCase>()
    private val listRepo = MutableLiveData<List<RepoGit>>()
    private val observer = relaxedMockk<Observer<ListRepoViewModel>>()
    private val mockListRepoGitResponse = listOf(
        RepoGit(
            id = "1",
            name = "kotlin",
            fullName = "full kotlin",
            avatarUrl = "http://www.url.com/",
            description = "Git repo kotlin laguage",
            language = "Kotlin",
            createdAt = "2022-11-05",
            updatedAt = "2022-11-05",
            htmlUrl = "https://www.github.com/"
        ),
        RepoGit(
            id = "2",
            name = "java",
            fullName = "full java",
            avatarUrl = "http://www.url.com/",
            description = "Git repo java laguage",
            language = "Java",
            createdAt = "2022-11-05",
            updatedAt = "2022-11-05",
            htmlUrl = "https://www.github.com/"
        )
    )

    @Before
    fun setup() {
        listRepoViewModel = ListRepoViewModel(
            getReposGitUseCase
        )
    }

    @Test
    fun `when ListRepoViewModel is created then should get a list of repositories from git and get data success`() {
        val slots = mutableListOf<ListRepoViewModel>()
        coEvery {
            getReposGitUseCase(
                ReposGitParams(
                    "kotlin",
                    "20",
                    "1"
                )
            )
        } answers {
            mockListRepoGitResponse
        }

        listRepoViewModel.getRepos()
    }
}