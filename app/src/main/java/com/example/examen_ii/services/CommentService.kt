package com.example.examen_ii.services

import com.example.examen_ii.data.ApiComment
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentService {
    @GET("posts/{id}/comments")
    suspend fun getCommentsByPostId(@Path("id") id: Int): List<ApiComment>
}