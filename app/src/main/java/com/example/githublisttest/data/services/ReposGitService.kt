package com.example.githublisttest.data.services

import com.example.githublisttest.data.models.APIReposGitResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ReposGitService {

    @GET("repositories")
    suspend fun getReposGit(
        @Query("q") query: String,
        @Query("per_page") perPage: String,
        @Query("page") page: String
    ) : APIReposGitResponse

}