package com.benxinm.novelapplication.service


import com.benxinm.novelapplication.bean.Book
import retrofit2.Call
import retrofit2.http.GET

interface BookService {
    @GET("get/book")
    fun getAllBooks(): Call<List<Book>>
}