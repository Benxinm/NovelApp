package com.benxinm.novelapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.benxinm.novelapplication.data.entity.UserEntity

@Dao
interface UserDao {
    @Query("select * from user where uid=(:userId)")
    fun findById(userId:Int): UserEntity
    @Insert
    fun insertAll( userEntity: UserEntity)
}