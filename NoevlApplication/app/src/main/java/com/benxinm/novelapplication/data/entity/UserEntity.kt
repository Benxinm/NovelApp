package com.benxinm.novelapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(@PrimaryKey var uid:Int,
                      @ColumnInfo(name="account") var account:String,
                      @ColumnInfo(name="psd") var psd:String )
