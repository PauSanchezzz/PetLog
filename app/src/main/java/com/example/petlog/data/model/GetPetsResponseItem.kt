package com.example.petlog.data.model

data class GetPetsResponseItem(
    val _id: String,
    val age: Int,
    val breed: String,
    val image: String,
    val name: String,
    val type: String,
    val v: Int
)
