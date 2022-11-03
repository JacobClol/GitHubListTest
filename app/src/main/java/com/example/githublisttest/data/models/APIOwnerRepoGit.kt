package com.example.githublisttest.data.models

import com.google.gson.annotations.SerializedName

data class APIOwnerRepoGit(
    @SerializedName("avatar_url")
    val avatarUrl: String
)
