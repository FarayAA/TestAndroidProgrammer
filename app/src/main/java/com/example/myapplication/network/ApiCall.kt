package com.example.myapplication.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCall {
    private const val URL = " https://jsonplaceholder.typicode.com/todos"
    private val okHttp = OkHttpClient.Builder()

//    private val gson = GsonBuilder()
//        .setLenient()
//        .create()

    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun<T> buildService (serviceType: Class<T>):T{
        return retrofit.create(serviceType)
    }
}