package com.yigitcan.mvvmlivenewskotlin.model

import com.google.gson.annotations.SerializedName

class NewsResponseModel {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("totalResults")
    var totalResults = 0

    @SerializedName("articles")
    var news: ArrayList<News>? = null
}