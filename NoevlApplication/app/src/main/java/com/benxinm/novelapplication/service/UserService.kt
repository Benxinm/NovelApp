package com.benxinm.novelapplication.service


import com.benxinm.novelapplication.bean.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    @GET("register")
    fun registerUser(@Query("ac") ac:String, @Query("psd") psd:String):Call<Int>
    @GET("login")
    fun login(@Query("ac") ac: String,@Query("psd") psd: String):Call<Map<Int,String>>
}