package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

class ResponseList(
    val userID: Int,
    val id: Int,
    val title: String,
    val complete: Boolean
) {
    data class DataBarang(
        val nama: String,
        @SerializedName("id")
        val id: Int
    )
}