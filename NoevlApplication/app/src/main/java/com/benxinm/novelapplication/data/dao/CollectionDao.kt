package com.benxinm.novelapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.benxinm.novelapplication.data.entity.CollectionEntity

@Dao
interface CollectionDao {
    @Query("select * from Collection where uid=:uid")
    fun getAllCollections(uid:String):List<CollectionEntity>
    @Insert
    fun addCollections(vararg collectionEntity: CollectionEntity)
}