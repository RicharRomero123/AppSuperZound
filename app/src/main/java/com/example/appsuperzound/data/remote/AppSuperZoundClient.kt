package com.example.appsuperzound.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppSuperZoundClient {
    private const val BASE_URL = "https://theaudiodb.com/api/v1/json/523532/"
    fun AppSuperZoundService(): AppSuperZoundService{
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(AppSuperZoundService::class.java)
    }
}