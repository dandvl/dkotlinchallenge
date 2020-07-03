package com.example.deltachallenge.network

import com.example.deltachallenge.data.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface PostService{

    @GET("posts")
    suspend fun all() : List<Post>

}


object WebService {
    val posts : PostService by lazy { retrofit.create(PostService::class.java) }
}