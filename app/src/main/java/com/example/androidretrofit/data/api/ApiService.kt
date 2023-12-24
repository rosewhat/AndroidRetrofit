package com.example.androidretrofit.data.api

import com.example.androidretrofit.domain.Info
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("android/posts.json")
    suspend fun getInfo() : List<Info>


    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}