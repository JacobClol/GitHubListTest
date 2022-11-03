package com.example.githublisttest.domain.exceptions

sealed class ListRepoGitError : Error() {

    class UnknownListError(val error: Error) : ListRepoGitError()
}