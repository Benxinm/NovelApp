package com.benxinm.novelapplication.service.impl

import com.benxinm.novelapplication.bean.Book
import com.benxinm.novelapplication.service.BookService
import com.benxinm.novelapplication.utils.ServiceCreator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


object BookServiceImpl {
    val bookService=ServiceCreator.create(BookService::class.java)
    fun getAllBook():List<Book>?{
        var bookList:List<Book>?=null
        val call= bookService.getAllBooks()
        GlobalScope.launch {
            bookList=call.execute().body()
        }
        Thread.sleep(500)
        return bookList
    }
}