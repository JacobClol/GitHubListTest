package com.example.githublisttest.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepoGit(
    val id: String,
    val name: String?,
    val fullName: String?,
    val avatarUrl: String?,
    val description: String?,
    val htmlUrl: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val language: String?
) : Parcelable
