package com.example.habittrackerapp.network

import com.example.habittrackerapp.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>
}