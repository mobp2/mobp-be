package com.example.mobp2.dto

data class AnimalResponseBody<T>(
    val items: AnimalResponseItems<T>?,
    val numOfRows: Int?,
    val pageNo: Int?,
    val totalCount: Int?,
)
