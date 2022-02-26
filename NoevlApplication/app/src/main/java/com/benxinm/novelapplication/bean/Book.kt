package com.benxinm.novelapplication.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Book(val id:String,val name:String,val author:String,val remark:String,val coverRef:String): Parcelable {
}