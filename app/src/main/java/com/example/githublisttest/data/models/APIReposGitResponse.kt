package com.example.githublisttest.data.models

import com.example.githublisttest.domain.models.RepoGit
import com.google.gson.annotations.SerializedName

data class APIReposGitResponse(
    @SerializedName("items")
    val itemRepoGit : List<APIItemRepo>
) {
    fun toListRepoGit(): List<RepoGit> =
            itemRepoGit.map {
                it.toRepoGit()
            }
}
