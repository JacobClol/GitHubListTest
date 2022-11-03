package com.example.githublisttest.data.mappers

import com.example.githublisttest.data.models.APIOwnerRepoGit

object APIOwnerRepoMapper {
    fun map(apiOwnerRepoGit: APIOwnerRepoGit): String {
        return apiOwnerRepoGit.avatarUrl
    }
}