package com.example.examen_ii.services

import com.example.examen_ii.data.ApiPost
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    suspend fun getAllPosts(): List<ApiPost>

    @GET("users/{id}/posts")
    suspend fun getPostsByUserId(@Path("id") id: Int): List<ApiPost>
}