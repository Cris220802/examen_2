package com.example.examen_ii.repositories

import com.example.examen_ii.data.ApiPost
import com.example.examen_ii.network.ClienteRetrofit
import com.example.examen_ii.services.PostService

class PostRepository(private val PostService: PostService = ClienteRetrofit.getInstancePostRetrofit) {
    suspend fun getAllPosts(): List<ApiPost> {
        return PostService.getAllPosts()
    }

    suspend fun getPostsByUserId(id: Int): List<ApiPost> {
        return PostService.getPostsByUserId(id)
    }
}