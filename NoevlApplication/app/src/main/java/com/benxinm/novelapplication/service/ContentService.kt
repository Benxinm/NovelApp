package com.benxinm.novelapplication.service

import com.benxinm.novelapplication.bean.Content
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ContentService {
    @GET("get/content")
    fun getContent(@Query("id") id:String): Call<Content>
}