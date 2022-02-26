package com.benxinm.novelapplication.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Collection")
data class CollectionEntity(var uid:String,
                            var bid:String,
                            var name:String,
                            var coverRef:String){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
