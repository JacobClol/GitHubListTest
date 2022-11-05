package com.example.githublisttest.mappers

import com.example.githublisttest.data.models.APIItemRepo
import com.example.githublisttest.data.models.APIOwnerRepoGit
import org.junit.Assert
import org.junit.Test

class APIItemRepoMapperTest : APIItemRepoMapperDeppendetTest() {

    @Test
    fun `show be able map from APIItemRepo to RepoGit`(){
        val repoGit = aPIItemRepoObjTest.toRepoGit()

        Assert.assertNotNull(repoGit)
        Assert.assertEquals(aPIItemRepoObjTest.id, repoGit.id)
        Assert.assertEquals(aPIItemRepoObjTest.name, repoGit.name)
        Assert.assertEquals(aPIItemRepoObjTest.fullName, repoGit.fullName)
        Assert.assertEquals(aPIItemRepoObjTest.ownerRepoGit.avatarUrl, repoGit.avatarUrl)
        Assert.assertEquals(aPIItemRepoObjTest.description, repoGit.description)
        Assert.assertEquals(aPIItemRepoObjTest.language, repoGit.language)
        Assert.assertEquals(aPIItemRepoObjTest.createdAt, repoGit.createdAt)
        Assert.assertEquals(aPIItemRepoObjTest.updatedAt, repoGit.updatedAt)
        Assert.assertEquals(aPIItemRepoObjTest.htmlUrl, repoGit.htmlUrl)
    }
}

abstract class APIItemRepoMapperDeppendetTest{
    protected val aPIItemRepoObjTest = APIItemRepo(
        id = "1",
        name = "kotlin",
        fullName = "full kotlin",
        ownerRepoGit = APIOwnerRepoGit(
            avatarUrl = "http://www.url.com/"
        ),
        description = "Git repo kotlin laguage",
        language = "Kotlin",
        createdAt = "2022-11-05",
        updatedAt = "2022-11-05",
        htmlUrl = "https://www.github.com/"
    )
}