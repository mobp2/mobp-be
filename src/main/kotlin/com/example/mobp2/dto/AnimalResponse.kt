package com.example.mobp2.dto

data class AnimalResponse<T>(
    val header: AnimalResponseHeader?,
    val body: AnimalResponseBody<T>?
)
