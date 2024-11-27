package com.example.examen_ii.repositories

import com.example.examen_ii.data.ApiUser
import com.example.examen_ii.network.ClienteRetrofit
import com.example.examen_ii.services.UserService

class UserRepository(private val UserService: UserService = ClienteRetrofit.getInstanciaRetrofit) {
    suspend fun getAllUsers(): List<ApiUser> {
        return UserService.getAllUsers()
    }
}