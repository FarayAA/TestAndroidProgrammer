package com.example.myapplication.network

import com.example.myapplication.model.ResponseList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("list")
    fun getlist(): Call<List<ResponseList>>
}