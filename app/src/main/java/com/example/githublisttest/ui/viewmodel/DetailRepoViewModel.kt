package com.example.githublisttest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githublisttest.domain.models.RepoGit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailRepoViewModel @Inject constructor() : ViewModel(){

    val repoDetail = MutableLiveData<RepoGit>()
    val repoError = MutableLiveData<String>()

    fun setDetail(repoGit: RepoGit?){
        repoGit?.let {
            repoDetail.postValue(it)
        } ?: repoError.postValue("No found Data")

    }
}