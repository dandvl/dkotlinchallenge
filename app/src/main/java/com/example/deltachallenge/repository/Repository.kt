package com.example.deltachallenge.repository

import com.example.deltachallenge.network.WebService

class Repository {
    suspend fun all() = WebService.posts.all()
}