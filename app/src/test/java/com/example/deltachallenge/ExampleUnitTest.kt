package com.example.deltachallenge

import com.example.deltachallenge.data.Post
import com.example.deltachallenge.repository.Repository
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testApiCall() = runBlocking {

        var posts = mock(Repository::class.java)

        var fakePostList = mutableListOf<Post>()

        fakePostList.add(Post(1,1,"title", "body"))
        fakePostList.add(Post(1,2,"title2", "body 2"))

        `when`(posts.all()).thenReturn(fakePostList)

        assertEquals(posts.all().size,2)
    }

}