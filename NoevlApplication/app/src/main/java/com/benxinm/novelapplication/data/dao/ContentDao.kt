package com.benxinm.novelapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomWarnings
import com.benxinm.novelapplication.data.entity.ContentEntity

@Dao
interface ContentDao {
    @Query("select * from Content where bid=:bookId")
    fun getContentById(bookId:String): ContentEntity
    @Insert
    fun download(contentEntity: ContentEntity)
    @Query("select count(*) from Content where bid=:bookId")
    fun checkExist(bookId: String):Int
}