package com.example.petlog.data.api

import com.example.petlog.data.model.GetPetsResponseItem
import com.example.petlog.data.model.PostAddPetsResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
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

    @Multipart
    @POST("/pets")
    suspend fun addPet(
        @Part("name") name: RequestBody,
        @Part("age") age: RequestBody,
        @Part("breed") breed: RequestBody,
        @Part("type") type: RequestBody,
        @Part image: MultipartBody.Part
    ): PostAddPetsResponse
}