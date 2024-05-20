package com.example.petlog.data.api

import com.example.petlog.data.model.GetPetsResponseItem
import retrofit2.http.GET

interface PetsApi {
    @GET("/pets")
    suspend fun getPets(): List<GetPetsResponseItem>
}