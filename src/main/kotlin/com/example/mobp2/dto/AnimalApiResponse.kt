package com.example.mobp2.dto

data class AnimalApiResponse<T>(
    val response: AnimalResponse<T>?
)
