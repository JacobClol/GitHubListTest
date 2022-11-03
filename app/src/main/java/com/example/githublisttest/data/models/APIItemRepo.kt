package com.example.githublisttest.data.models

import com.example.githublisttest.data.mappers.APIOwnerRepoMapper
import com.example.githublisttest.domain.models.RepoGit
import com.google.gson.annotations.SerializedName

data class APIItemRepo(
    @SerializedName("id")
    val id : String,
    @SerializedName("name")
    val name : String,
    @SerializedName("full_name")
    val fullName : String,
    @SerializedName("owner")
    val ownerRepoGit: APIOwnerRepoGit,
    @SerializedName("description")
    val description : String,
    @SerializedName("language")
    val language: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("html_url")
    val htmlUrl: String
){
    fun toRepoGit(): RepoGit{
        return RepoGit(
            id = id,
            name = name,
            fullName = fullName,
            avatarUrl =  APIOwnerRepoMapper.map(ownerRepoGit),
            description = description,
            htmlUrl = htmlUrl,
            createdAt = createdAt,
            updatedAt = updatedAt,
            language = language
        )
    }
}
