package com.example.petlog.di

import com.example.petlog.data.api.PetsApi
import com.example.petlog.data.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPet {
    val webService: PetsApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PetsApi::class.java)
    }
}