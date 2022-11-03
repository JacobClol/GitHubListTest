package com.example.githublisttest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githublisttest.domain.models.RepoGit
import com.example.githublisttest.domain.models.ReposGitParams
import com.example.githublisttest.domain.usecases.GetReposGitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class ListRepoViewModel @Inject constructor(
    private val getReposGitUseCase: GetReposGitUseCase
) : ViewModel() {

    val listRepo = MutableLiveData<List<RepoGit>>()
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String?>()
    private var query: String = "kotlin"
    private var perPage: String = "20"
    private var page: String = "1"

    //fun to set param by action fab button for user
    fun setParams(mQuery: String, mPerPage: String, mPage: String) {
        query = mQuery
        perPage = mPerPage
        page = mPage
    }

    fun getRepos() {
        viewModelScope.launch {
            isLoading.postValue(true)
            try {
                val repos = withContext(coroutineContext) {
                    getReposGitUseCase.invoke(
                        ReposGitParams(
                            query,
                            perPage,
                            page
                        )
                    )
                }
                handleListRepoGitSucess(repos)
            } catch (e: Exception) {
                handleListRepoGitFailure(e)
            }
            isLoading.postValue(false)
        }
    }

    private fun handleListRepoGitFailure(exception: Exception) {
        val listRepoGitError = exception.message
        error.postValue(listRepoGitError)
    }

    private fun handleListRepoGitSucess(repos: List<RepoGit>) {
        listRepo.postValue(repos)
    }
}