package com.example.examen_ii.services

import com.example.examen_ii.data.ApiUser
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users")
    suspend fun getAllUsers(): List<ApiUser>
}