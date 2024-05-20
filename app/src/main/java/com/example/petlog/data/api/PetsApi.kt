package com.example.petlog.data.api

import com.example.petlog.data.dto.GetPetsResponse
import retrofit2.http.GET

interface PetsApi {
    @GET("pets")
    suspend fun getPets(): GetPetsResponse
}