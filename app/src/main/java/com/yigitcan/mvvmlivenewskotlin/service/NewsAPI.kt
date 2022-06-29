package com.yigitcan.mvvmlivenewskotlin.service

import com.yigitcan.mvvmlivenewskotlin.model.NewsResponseModel
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPI {
    @GET("top-headlines")
    fun loadChanges(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsResponseModel?>?
}