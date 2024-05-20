package com.example.petlog.data.repository

import com.example.petlog.data.api.PetsApi
import javax.inject.Inject

class PetsRepository @Inject constructor(
    private val petsApi: PetsApi
){
    suspend fun getAllPets() = petsApi.getPets()
}