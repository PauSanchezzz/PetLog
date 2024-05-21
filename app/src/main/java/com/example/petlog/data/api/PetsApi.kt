package com.example.petlog.data.api

import com.example.petlog.data.model.GetPetsResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface PetsApi {
    @GET("/pets")
    suspend fun getPets(): List<GetPetsResponseItem>

    @GET("/pets/filter")
    suspend fun getPet(
        @Query("name") name: String
    ): List<GetPetsResponseItem>

    @GET("/pets/filter")
    suspend fun getPetsSortBy(
        @Query("sortBy") sortBy: String
    ): List<GetPetsResponseItem>
}