package com.example.appsuperzound.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AppSuperZoundService {
    @GET("mostloved.php")
    fun getAllAlbums(@Query("format") album:String): Call<AppSuperZoundResponse>
}