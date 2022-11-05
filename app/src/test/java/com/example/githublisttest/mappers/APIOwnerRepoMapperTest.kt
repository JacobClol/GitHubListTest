package com.example.githublisttest.mappers

import com.example.githublisttest.data.mappers.APIOwnerRepoMapper
import com.example.githublisttest.data.models.APIOwnerRepoGit
import org.junit.Assert
import org.junit.Test

class APIOwnerRepoMapperTest {

    @Test
    fun `should map from APIOwnerRepoGit and return avatarUrl`(){

        val result = APIOwnerRepoMapper.map(
            APIOwnerRepoGit(
                "http://www.url.com/"
            )
        )

        Assert.assertEquals(result, "http://www.url.com/")
    }
}