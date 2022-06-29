package com.yigitcan.mvvmlivenewskotlin.model

import com.google.gson.annotations.SerializedName


class News {
    @SerializedName("source")
    var source: NewsSourceModel? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("urlToImage")
    var urlToImage: String? = null

    @SerializedName("publishedAt")
    var publishedAt: String? = null
}