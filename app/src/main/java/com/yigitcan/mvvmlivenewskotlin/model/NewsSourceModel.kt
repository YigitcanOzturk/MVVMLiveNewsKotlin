package com.yigitcan.mvvmlivenewskotlin.model

import com.google.gson.annotations.SerializedName


class NewsSourceModel {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null
}