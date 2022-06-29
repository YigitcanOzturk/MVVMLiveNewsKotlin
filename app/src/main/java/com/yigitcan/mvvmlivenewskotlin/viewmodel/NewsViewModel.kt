package com.yigitcan.mvvmlivenewskotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import com.yigitcan.mvvmlivenewskotlin.model.News
import com.yigitcan.mvvmlivenewskotlin.model.NewsResponseModel
import com.yigitcan.mvvmlivenewskotlin.service.NewsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsViewModel : ViewModel(), Callback<NewsResponseModel?> {
    var userMutableLiveData: MutableLiveData<ArrayList<News>?> = MutableLiveData()
    private var newsArrayList: ArrayList<News>? = null
    private fun init() {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val newsAPI = retrofit.create(NewsAPI::class.java)
        val call: Call<NewsResponseModel?>? = newsAPI.loadChanges("tr", API_KEY)
        call?.enqueue(this)
    }

    override fun onResponse(call: Call<NewsResponseModel?>?, response: Response<NewsResponseModel?>) {
        if (response.body()?.status.equals("ok")) {
            newsArrayList = ArrayList()
            newsArrayList = response.body()?.news
            userMutableLiveData.setValue(newsArrayList)
        } else {
            println(response.errorBody().toString() + "error")
        }
    }

    override fun onFailure(call: Call<NewsResponseModel?>?, t: Throwable) {
        t.printStackTrace()
    }

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "588ca767d0ad4629b5d3b06d21e4c028"
    }

    init {

        // we call the Rest API in init method
        init()
    }
}