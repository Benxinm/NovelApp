package com.benxinm.novelapplication.data.entity


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "Content")
data class ContentEntity(@PrimaryKey @ColumnInfo(name = "bid")  var bid:String,
                         @ColumnInfo(name = "content") var content:String)